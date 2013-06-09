package com.keyManage.service.contain;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.Contain;
import com.keyManage.bean.KindOfKey;
import com.keyManage.dao.contain.ContainDAO;
import com.keyManage.dao.keyMessage.KeyMessageDAO;
import com.keyManage.dao.kindOfKey.KindOfKeyDAO;
import com.keyManage.util.CountObject;

public class ContainServiceImpl implements ContainService {
	
	private ContainDAO containDAO;
	private KindOfKeyDAO kindOfKeyDAO;
	private KeyMessageDAO keyMessageDAO;

	@Override
	public void addContain(Contain contain) {
		containDAO.insert(contain);
	}
	
	@Override
	public void update(Contain contain) {
		containDAO.update(contain);
	}
	
	@Override
	public void removeAll(String[] ids) {
		Contain contain;
		for(String id:ids){
			contain=containDAO.findByPrimaryKey(id);
			contain.setIsDelete("0");
			containDAO.update(contain);
		}
	}

	@Override
	public Contain findByPrimaryKey(String id) {
		return containDAO.findByPrimaryKey(id);
	}

	@Override
	public List<Contain> findListByParams(Map<String, Object> params) {
		return containDAO.findListByParams(params);
	}

	@Override
	public PaginationSupport findByPage(Map<String, Object> params,
			int currentPage, int pageSize) {
		return containDAO.findByPage(params, currentPage, pageSize);
	}
	
	/**
	 * 按KindOfKeyID算取各种锁的剩余数量
	 * */
	public List<CountObject> findLastKey(){
		List<CountObject> countObjectList = containDAO.findCountByKindOfKeyID("0");
		List<CountObject> countTokenList = containDAO.findCountByKindOfKeyID("1");
		String[] ids=new String[countObjectList.size()];
		for(int i=0;i<countObjectList.size();i++){
			ids[i]=countObjectList.get(i).getItem();
		}
		if(ids.length>0){
			List<KindOfKey> kindOfKeyList=kindOfKeyDAO.findByIds(ids);
		
			for(int i=0;i<countObjectList.size();i++){
			//往CountObject中添加name与备注
				CountObject addItem = countObjectList.get(i);
				addItem.setName(kindOfKeyList.get(i).getKindName());
				addItem.setRemark(kindOfKeyList.get(i).getRemark());
				for(CountObject c:countTokenList){
					if(addItem.getItem().equals(c.getItem())){
						//入库减去出库
						addItem.setNum(addItem.getNum()-c.getNum());
					}
				}
			}
		}
		return countObjectList;
	}
	
	/**
	 * 按KindOfKeyID和批号算取各种锁的剩余数量
	 * */
	public List<CountObject> findLastKey(String kindOfKeyID){
		List<CountObject> countObjectList = containDAO.findCountLotNumberByKindOfKeyID("0", kindOfKeyID);
		List<CountObject> countTokenList = containDAO.findCountLotNumberByKindOfKeyID("1", kindOfKeyID);
		for(int i=0;i<countObjectList.size();i++){
		//往CountObject中添加name与备注
			CountObject addItem = countObjectList.get(i);
			for(CountObject c:countTokenList){
				if(addItem.getItem().equals(c.getItem())){
				//入库减去出库
					addItem.setNum(addItem.getNum()-c.getNum());
				}
			}
		}
		return countObjectList;
	}
	
	@Override
	public void addAllContain(List<Contain> ContainList) {
		containDAO.insertAllContain(ContainList);
	}
	
	/**
	 * 按请求锁的id查询锁的剩余数量
	 * */
	public Integer findCountNumByKeyAskID(String keyAskID,String isDelete){
		return containDAO.findCountNumByKeyAskID(keyAskID, isDelete);
	}
	
	/**
	 * 按KindOfKeyID和批号算取各种锁的数量
	 * */
	public List<CountObject> findCountLotNumberByKindOfKeyID(String saveOrTake,String kindOfKeyID){
		return containDAO.findCountLotNumberByKindOfKeyID(saveOrTake,kindOfKeyID);
	}
	
	/**
	 * 计算锁用途中减去已经填写用途的锁的每批锁的数量
	 * */
	public List<Contain> findLastNumOfContain(String keyAskId){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("isDelete", "1");
		params.put("keyAsk.id", keyAskId);
		//未减去已经填写用途的锁前的每批锁的数量
		List<Contain> containList = containDAO.findListByParams(params);
		if(containList!=null&&containList.size()!=0){
			String[] containIds=new String[containList.size()];
			for(int i= 0;i<containList.size();i++){
				containIds[i]=containList.get(i).getId();
			}
			List<CountObject> countObjectList=keyMessageDAO.findNumByContainIds(containIds);
			//每批总数减去已经填写用途的锁的每批锁的数量
			if(countObjectList!=null&&countObjectList.size()!=0){
				for(Contain contain:containList){
					for(CountObject countObject:countObjectList){
						if(contain.getId().equals(countObject.getItem())){
							int num = contain.getKeyNum()-countObject.getNum();
							contain.setKeyNum(num);
						}
					}
				}
			}
		}
		return containList;
	}
	
	//计算一个请求单中的已经用掉的锁得数量(暂不使用)
	public Integer findNumOfUsed(String keyAskId){
		Integer num=0;
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("isDelete", "1");
		params.put("keyAsk.id", keyAskId);
		//未减去已经填写用途的锁前的每批锁的数量
		List<Contain> containList = containDAO.findListByParams(params);
		if(containList!=null&&containList.size()!=0){
			String[] containIds=new String[containList.size()];
			for(int i= 0;i<containList.size();i++){
				containIds[i]=containList.get(i).getId();
			}
			List<CountObject> countObjectList=keyMessageDAO.findNumByContainIds(containIds);
			//每批总数减去已经填写用途的锁的每批锁的数量
			if(countObjectList!=null&&countObjectList.size()!=0){
				for(CountObject countObject:countObjectList){
					num=countObject.getNum()+num;
				}
			}
		}
		return num;
	}
	
	/**按锁种类id查询*/
	public Integer findNumByKindOfKeyID(String kindOfKeyID){
		Integer num=0;
		List<CountObject> countObjectList= this.findLastKey();
		for(CountObject countObject:countObjectList){
			if(countObject.getItem().equals(kindOfKeyID)){
				num=countObject.getNum();
			}
		}
		return num;
	}
	
	/**自定义查询*/
	public List<Contain> findListByParams(Map<String, Object> params,Map<String, Object> likeParams,Map<String, Timestamp[]> betweenParams,Map<String, String[]> inParams){
		return containDAO.findListByParams(params, likeParams, betweenParams, inParams);
	}
	
	public ContainDAO getContainDAO() {
		return containDAO;
	}

	public void setContainDAO(ContainDAO containDAO) {
		this.containDAO = containDAO;
	}

	public KindOfKeyDAO getKindOfKeyDAO() {
		return kindOfKeyDAO;
	}

	public void setKindOfKeyDAO(KindOfKeyDAO kindOfKeyDAO) {
		this.kindOfKeyDAO = kindOfKeyDAO;
	}

	public KeyMessageDAO getKeyMessageDAO() {
		return keyMessageDAO;
	}

	public void setKeyMessageDAO(KeyMessageDAO keyMessageDAO) {
		this.keyMessageDAO = keyMessageDAO;
	}

}

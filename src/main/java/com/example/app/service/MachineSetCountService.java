package com.example.app.service;

import java.time.LocalDate;
import java.util.List;

import com.example.app.domain.Machine;
import com.example.app.domain.MachineSetCount;


public interface MachineSetCountService {

//登録//
	//筋トレ記録登録
	void addMachineSetCount(MachineSetCount machineRecord) throws Exception;

//表示//
	//筋トレマシン一覧表示
	List<Machine> getSelectMachine() throws Exception;

	//カレンダーから特定の日の筋トレ記録表示
	List<MachineSetCount> getMachineSetCountDay(LocalDate day, int userId) throws Exception;
	
	//マシン数をカウント
	int getCountMachine() throws Exception;

	//グラフ表示（machineId=1 bench press）
	List<MachineSetCount> getSelectChartMachineId1(int userId, int machineId) throws Exception;
		
	//グラフ表示
//	List<MachineSetCount> getSelectChart(int userId) throws Exception;
	


//編集//
	//筋トレ記録編集
//	void editMachineSetCount(MachineSetCount machineRecord) throws Exception;

//削除//
	//筋トレ記録削除
//	void deleteMachineSetCount(LocalDateTime date) throws Exception;
}
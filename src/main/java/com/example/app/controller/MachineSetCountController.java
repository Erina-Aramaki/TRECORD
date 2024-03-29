package com.example.app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.Machine;
import com.example.app.domain.MachineSetCount;
import com.example.app.service.MachineSetCountService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MachineSetCountController {

//！！！！！後ほどRecordControllerと結合する！！！！！



	private final MachineSetCountService service;


//筋トレ記録の登録
	@GetMapping("/record_aramaki")
	public String register(
			Model model,
			HttpSession session) throws Exception{
		MachineSetCount machineSetCount = new MachineSetCount();

//!!!!!!!!!!!ダミーデータ!!!!!!!!!!!!!!!!!!!!!!!!
		machineSetCount.setUserId(1);

		//ユーザーID
//		User user = (User) session.getAttribute("user");
//		machineSetCount.setUserId(user.getUserId());
//		System.out.println("user.getUserId()" + user.getUserId());


		//日付
		LocalDate now = LocalDate.now();
		machineSetCount.setDate(now);
		System.out.println("今日の日付：" + machineSetCount.getDate());

		//筋トレマシン一覧表示
		List<Machine> machine = service.getSelectMachine();
		model.addAttribute("machine", machine);

		//重量
		model.addAttribute("weight", 100);

		//回数
		model.addAttribute("numCount", 30);
		machineSetCount.setMachineCount(10);
		System.out.println(machineSetCount.getMachineCount());

		//セット数
		model.addAttribute("numSet", 10);

		//日付、回数の初期値を設定
		model.addAttribute("machineSetCount", machineSetCount);

		return "charge/record_aramaki";
	}


	@PostMapping("/record_aramaki")
	public String recodeDone(
			@Valid MachineSetCount machineSetCount,
			Errors errors,
			Model model) throws Exception{

//		if(errors.hasErrors()) {
//			model.addAttribute("machine", machineSetCount);
//			return "charge/record_aramaki";
//		}



		System.out.println(machineSetCount);
		service.addMachineSetCount(machineSetCount);

		return "recordDone";
	}


//筋トレ記録の表示（show）
	@GetMapping("/show_aramaki")
	public String showDay(
			HttpServletRequest request,
			Model model) throws Exception {

		//カレンダーから特定の日の筋トレ記録を取得

//!!!!!!!!!!!ダミーデータ!!!!!!!!!!!!!!!!!!!!!!!!
		LocalDate date = DateTimeFormatter.ofPattern("yyyy-MM-dd").parse("2024-02-02", LocalDate::from);

		//RecordControllerでエラーが発生しないようにコメントアウト
//		MachineSetCount machineSetCount = new MachineSetCount();
//		machineSetCount.setUserId(1);
//		List<MachineSetCount> getDayData = service.getMachineSetCountDay(date, machineSetCount.getUserId());
//		machineSetCount.setDate(date);
//
//		System.out.println("getDayData：" + getDayData);
//
//		model.addAttribute("machineSetCount", getDayData);

		return "charge/show_aramaki";
	}







}

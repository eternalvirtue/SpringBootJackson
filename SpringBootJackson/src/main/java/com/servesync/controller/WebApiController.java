package com.servesync.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.servesync.bean.ParameterBody;
import com.servesync.bean.ParameterCoverage;

@RestController
@RequestMapping("api")
public class WebApiController {

    @RequestMapping("hello")
    private String hello() {
        return "SpringBoot!";
    }

	@RequestMapping(value = "/calc", method = {RequestMethod.POST})
	@ResponseBody
	@CrossOrigin
	public ParameterBody output1(@RequestBody ParameterBody parameter) {
		// レスポンスデータ加工
		List<ParameterCoverage> coverages = parameter.getCoverage();
		for (int i = 0; i < coverages.size(); i++) {
			coverages.get(i).setPrem(1000 + i * 100);
		}
		parameter.setResultCode("000");
		return parameter;
	}
}

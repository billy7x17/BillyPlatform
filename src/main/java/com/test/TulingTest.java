package com.test;

import com.fields.robot.Train;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TulingTest
{
	public static void main(String[] args)
	{
		String testJson = "{\"code\":305000,\"text\":\"亲，已帮您找到列车信息\",\"list\":[{\"trainnum\":\"Z322/Z323(直达特快)\",\"start\":\"北京\",\"terminal\":\"沈阳北\",\"starttime\":\"04:46\",\"endtime\":\"13:05\",\"icon\":\"http://unidust.cn/images/api-train.jpg\",\"detailurl\":\"http://touch.qunar.com/h5/train/\"},{\"trainnum\":\"K1112/K1113(快速)\",\"start\":\"北京\",\"terminal\":\"沈阳\",\"starttime\":\"04:57\",\"endtime\":\"15:28\",\"icon\":\"http://unidust.cn/images/api-train.jpg\",\"detailurl\":\"http://touch.qunar.com/h5/train/\"}]}";
		
		JSONObject train = JSONObject.fromObject(testJson);
		
		Train a = (Train)JSONObject.toBean(train , Train.class);
	}
}

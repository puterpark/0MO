package com.kosmo.omo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import com.kosmo.vo.OpenVO;

public class KakaoTest4 {

	public HashMap<String, Object> openAPI(OpenVO ovo) {
		String result = "";
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		try {
			System.out.println(ovo.getUrl());
			URL connURL = new URL(ovo.getUrl());
			HttpURLConnection conn = (HttpURLConnection)connURL.openConnection();

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setDefaultUseCaches(false);
			conn.setRequestMethod(ovo.getRequestMethod());
//			
				conn.setRequestProperty("Host", ovo.getHost());
				conn.setRequestProperty("Authorization", ovo.getAuth());
//		
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");


			StringBuffer buffer = new StringBuffer();
			for (String mapkey : ovo.getMap().keySet()){
				buffer.append(mapkey).append("=").append(ovo.getMap().get(mapkey)).append("&");   //파라미터
			}

			OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			PrintWriter pw = new PrintWriter(osw);
			pw.write(buffer.toString());
			System.out.println("파라미터값:"+buffer.toString());
			pw.flush();

			//구글에서 온 답변 받기
			int responseCode = conn.getResponseCode();
			resMap.put("code", responseCode);

			System.out.println("응답받기 ::::  " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) { //success

				InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				StringBuilder builder = new StringBuilder();
				String inputLine;
				while ((inputLine = br.readLine()) != null) {
					builder.append(inputLine + "\n");
				}
				br.close();
				result = builder.toString();
				resMap.put("message", result);

				System.out.println(result);
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resMap;

	}

	//	파라미터값:cid=TC0ONETIME&partner_order_id=20180410LV50&partner_user_id=COMEALONE&item_name=러브볼50개충전&quantity=1&total_amount=5000&tax_free_amount=5000&vat_amount=0&approval_url=http://localhost/alone/community/kakaopay.jsp&cancel_url=http://localhost/alone/community/kakaopay.jsp&fail_url=http://localhost/alone/community/kakaopay.jsp
	//	파라미터값:partner_order_id=20180410LV50&quantity=1&vat_amount=0&total_amount=5000&tax_free_amount=5000&partner_user_id=COMEALONE&item_name=러브볼50개충전&approval_url=http://localhost/alone/community/kakaopay.jsp&cancel_url=http://localhost/alone/community/kakaopay.jsp&fail_url=http://localhost/alone/community/kakaopay.jsp&cid=TC0ONETIME&
	//	

//	@RequestMapping(value = "/kakao4.do")
//	@ResponseBody
//	public String getCode3(@RequestBody OpenVO ovo) {
////		OpenVO ovo = new OpenVO();
//		HashMap<String, Object> prm = new HashMap<String, Object>();
//		HashMap<String, Object> resMap = new HashMap<String, Object>();
//		
//		
//		prm.put("cid","TC0ONETIME");
//		prm.put("partner_order_id","20180410LV5057489s7");
//		prm.put("partner_user_id","COMEALONE");
//		prm.put("item_name","러브볼50개충전");
//		prm.put("quantity",+1);
//		prm.put("total_amount",+1);
//		prm.put("tax_free_amount",+1);
//		prm.put("vat_amount",+0);
//		prm.put("approval_url","http://localhost/community/main.do");
//		prm.put("cancel_url","http://localhost/alone/community/kakaopay.jsp");
//		prm.put("fail_url","http://localhost/alone/community/kakaopay.jsp");
//
//		ovo.setUrl("https://kapi.kakao.com/v1/payment/ready");
//		ovo.setRequestMethod("POST");
//		ovo.setHost("https://kapi.kakao.com");
////		ovo.setAuth("Bearer {aLzkwoXVVzjlunBCaRe2bRDedh8hk6nKWM1iGAo8BdgAAAFirxCXKA}");  //ACCESS_TOKEN
//		ovo.setAuth("Bearer {"+ovo.getAccess_token()+"}");  //ACCESS_TOKEN
////		ovo.setAuth("KakaoAK {d17be967963b0f416b148fdb8b4069f9}");
//		ovo.setMap(prm);
//
//		resMap = openAPI(ovo);
//		System.out.println(resMap.get("code") + "----" + resMap.get("message"));
//		
//
//		
//		
//	
//		
//		return (String) resMap.get("message");
//
//	}
	
	
	/*@RequestMapping(value = "/kakao2.do")
	@ResponseBody
	public String getCode(@RequestBody OpenVO ovo) {
//	public String getCode() {
//		OpenVO ovo = new OpenVO();
		System.out.println("++++++++++++++++++++++++"+ovo.getAccess_token());
		HashMap<String, Object> prm = new HashMap<String, Object>();
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		
		
		prm.put("cid","TC0ONETIME");
		prm.put("partner_order_id","20180410LV5057489s7");
		prm.put("partner_user_id","COMEALONE");
		prm.put("item_name","러브볼50개충전");
		prm.put("quantity",+1);
		prm.put("total_amount",+5000);
		prm.put("tax_free_amount",+5000);
		prm.put("vat_amount",+0);
		prm.put("approval_url","http://localhost/alone/community/kakaopay.jsp");
		prm.put("cancel_url","http://localhost/alone/community/kakaopay.jsp");
		prm.put("fail_url","http://localhost/alone/community/kakaopay.jsp");

		ovo.setUrl("https://kapi.kakao.com/v1/payment/ready");
		ovo.setRequestMethod("POST");
		ovo.setHost("https://kapi.kakao.com");
		
//		ovo.setAuth("bearer {2IVvorBMCmO2nWR9ecUZ9Jod4DGSzTh6LrWhFgopdkgAAAFirwLtQA}");  //ACCESS_TOKEN
		ovo.setAuth("bearer {"+ovo.getAccess_token()+"}");  //ACCESS_TOKEN
//		ovo.setAuth("KakaoAK {d17be967963b0f416b148fdb8b4069f9}");
		ovo.setMap(prm);

		resMap = openAPI(ovo);
		System.out.println(resMap.get("code") + "----" + resMap.get("message"));

		return "인증성고";

	}
*/

}

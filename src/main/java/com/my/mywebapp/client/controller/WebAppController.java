/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.my.mywebapp.client.controller;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

import java.util.ArrayList;
import java.util.List;

import com.my.mywebapp.shared.models.PeopleList;
import com.my.mywebapp.client.json.JsonHelper;
import com.my.mywebapp.client.ui.CellTableExample;


/**
 *
 * @author MikhailovAN
 */
public class WebAppController {
    private List<PeopleList> lst;
    CellTableExample CTable;

    public WebAppController(CellTableExample pCTable) {
        CTable = pCTable;
        lst = new ArrayList<PeopleList>(); 
        Window.alert("1 Controller constructor list = " + lst);
//        lst = new List<People>();
    }
//пока не используется
    public List<PeopleList> GetList() {
        Window.alert("4 Controller GetList list = " + lst);
        return lst;
    }

    public void loadPeopleList() {
		String pageBaseUrl = GWT.getHostPageBaseURL();
		// String baseUrl = GWT.getModuleBaseURL();
		RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, pageBaseUrl + "rest/getall/");
		rb.setCallback(new RequestCallback() {

			public void onError(Request request, Throwable e) {
				// some error handling code here
				Window.alert("error = " + e.getMessage());
			}

			public void onResponseReceived(Request request, Response response) {
				if (200 == response.getStatusCode()) {
					String text = response.getText();
					// some code to further handle the response here
					System.out.println("text = " + text);
					Window.alert("2 Сontroller response = " + text);
					lst = JsonHelper.parseDataList(text);
                                        CTable.InitTableExample(lst);
                                        //if (lst.isEmpty()) lst = new ArrayList<PeopleList>(); 
                                        Window.alert("4 Сontroller loadPeopleList lst = " + lst);
				}
			}
		});
		try {
			rb.send();
		} catch (RequestException e) {
			e.printStackTrace();
			Window.alert("error = " + e.getMessage());
		}

    }
}

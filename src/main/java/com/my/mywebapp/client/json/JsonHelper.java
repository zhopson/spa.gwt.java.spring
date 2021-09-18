package com.my.mywebapp.client.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.core.client.JavaScriptObject;


import com.my.mywebapp.shared.models.PeopleList;

public class JsonHelper {

	@SuppressWarnings("unchecked")
	public static List<PeopleList> parseDataList(String json) {
		List<PeopleList> peopleList = new ArrayList<PeopleList>();
		JSONValue jsonVal = JSONParser.parseStrict(json);
		JSONArray array = jsonVal.isArray();
		//JsArray<JsPeople> array = (JsArray<JsPeople>) object.getJavaScriptObject();
		if (array != null) {
//                    try {
			for (int i = 0; i < array.size(); i++) {
				//JsPeople jsPeople = array.get(i);
                                JSONValue item = array.get(i);
                                PeopleList pp = parsePeople(item.toString());
                                if (pp != null) {
                                  peopleList.add(pp);
                                }
//				int id = jsPeople.id();
//				String surname = jsPeople.surname();
//				String name = jsPeople.name();
//				String patronymic = jsPeople.patronymic();

				
			}
//                    } catch (Exception e) {    
//                        System.out.println(e.getMessage());
//                        peopleList.add(new PeopleList(1,"Михайлов","Андрей","Николаевич")); 
//                    }
		}
		return peopleList;
	}
        public static PeopleList parsePeople(String extraString ) {

            int id = 0;
            String surname = "";
            String name = "";
            String patronymic = "";
            
            if (extraString != null) {
                JSONValue extraJSONValue = JSONParser.parseStrict(extraString);
                JSONObject extraJSONObject = extraJSONValue.isObject();
                if (extraJSONObject != null) {
                    JSONValue NameJSONValue = extraJSONObject.get("name");
                    if (NameJSONValue != null) {
                        JSONString NameJSONString = NameJSONValue.isString();
                        if (NameJSONString != null) {
                            name = NameJSONString.stringValue();
                        }
                    }

                    JSONValue idJSONValue = extraJSONObject.get("id");
                    if (idJSONValue != null) {
                        JSONNumber idJSONNumber = idJSONValue.isNumber();
                        if (idJSONNumber != null) {
//                            id = Integer.parseInt(idJSONNumber.stringValue());
                            id = (int )idJSONNumber.doubleValue();
                        }
                    }

                    JSONValue surnameJSONValue = extraJSONObject.get("surname");
                    if (surnameJSONValue != null) {
                        JSONString surnameJSONString = surnameJSONValue.isString();
                        if (surnameJSONString != null) {
                            surname = surnameJSONString.stringValue();
                        }
                    }

                    JSONValue patronymicJSONValue = extraJSONObject.get("patronymic");
                    if (patronymicJSONValue != null) {
                        JSONString patronymicJSONString = patronymicJSONValue.isString();
                        if (patronymicJSONString != null) {
                            patronymic = patronymicJSONString.stringValue();
                        }
                    }
                    return new PeopleList(id,surname,name,patronymic);
                }
                else return null;
            }
            else  return null;
        }
}
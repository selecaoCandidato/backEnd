package br.com.selecao.candidato.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Optional;

public class GsonResponse {

	public String toJson(Object obj){
		GsonBuilder gsonBuilder = new GsonBuilder().setExclusionStrategies(createStrategy());
		Gson gson = gsonBuilder.create();

		String json = gson.toJson(processOptional(obj));

		return json;
	}

	private Object processOptional(Object obj) {
		if(obj instanceof Optional)
			return ((Optional) obj).get();
		else return obj;
	}

	private ExclusionStrategy createStrategy(){
		ExclusionStrategy strategy = new ExclusionStrategy() {
			@Override
			public boolean shouldSkipClass(Class<?> clazz) {
				return false;
			}

			@Override
			public boolean shouldSkipField(FieldAttributes field) {
				return field.getAnnotation(GsonExclude.class) != null;
			}
		};

		return strategy;
	}
}

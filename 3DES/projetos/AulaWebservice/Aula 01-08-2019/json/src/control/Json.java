package control;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Aluno;

public class Json {
	
	public Json() {
		
		/*String[] telefones = {"1234-4321", "7894-4987"};
		
		JSONObject obj = new JSONObject();
	
		obj.put("nome", "Fulano");
		obj.put("idade", 30);
		obj.put("telefones", telefones);
		obj.put("habilitado", true);
		
		//System.out.println(obj.toString());
		
		System.out.println("Nome - " + obj.get("nome"));
		System.out.println("Idade - " + obj.get("idade"));
		System.out.println("Telefones - " + obj.get("telefones"));
		System.out.println("Hablitado - " + obj.get("habilitado"));*/
		
		/*int idade = obj.getInt("idade");
		boolean habilidade = obj.getBoolean("habilitado");
		
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		
		obj.put("filme", "As Branquelas");
		obj.put("ano", 2000);
		
		arr.put(obj);
		
		obj = new JSONObject();
		
		obj.put("filme", "Capitão América");
		obj.put("ano", 2011);
		
		arr.put(obj);
		
		System.out.println(arr.toString());
		
		for(int i = 0; i < arr.length(); i++) {
			obj = arr.getJSONObject(i);
			System.out.println("Nome - " + obj.get("filme"));
			System.out.println("Ano - " + obj.get("ano"));*/
		
		List<Aluno> lista = new ArrayList<>();
		
		Aluno a = new Aluno();
		
		a.setNome("Jailson");
		a.setRa(123);
		
		lista.add(a);
		
		a = new Aluno();
		
		a.setNome("Cremilda");
		a.setRa(456);
		
		lista.add(a);
		
		JSONArray arr = new JSONArray(lista);
		
		System.out.println(arr.toString());
		
		
		
		
	}
}

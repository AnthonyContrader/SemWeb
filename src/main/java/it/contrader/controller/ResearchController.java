package it.contrader.controller;

import it.contrader.main.MainDispatcher;
import java.util.List;
import it.contrader.dto.ResearchDTO;
import it.contrader.service.ResearchService;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class ResearchController implements Controller {

	/**
	 * definisce il pacchetto di vista research.
	 */
	private static String sub_package = "research.";
	
	private ResearchService researchService;
	/**
	 * Costruisce un oggetto di tipo ResearchService per poterne usare i metodi
	 */
	public ResearchController() {
		this.researchService = new ResearchService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");

		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String keyWord;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			ResearchDTO researchDTO = researchService.read(id);
			request.put("research", researchDTO);
			MainDispatcher.getInstance().callView(sub_package + "ResearchRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			keyWord = request.get("keyWord").toString();
			
			//costruisce l'oggetto user da inserire
			ResearchDTO researchtoinsert = new ResearchDTO(keyWord);
			//invoca il service
			researchService.insert(researchtoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "ResearchInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			researchService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ResearchDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			keyWord = request.get("keyWord").toString();
			ResearchDTO researchtoupdate = new ResearchDTO(keyWord);
			researchtoupdate.setId(id);
			researchService.update(researchtoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ResearchUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "RESEARCHLIST":
			List<ResearchDTO> researchesDTO = researchService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("researches", researchesDTO);
			MainDispatcher.getInstance().callView("Research", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ResearchRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ResearchInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ResearchUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ResearchDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}

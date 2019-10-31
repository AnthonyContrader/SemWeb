package it.contrader.controller;

import it.contrader.main.MainDispatcher;
import java.util.List;

import it.contrader.dto.DictionaryDTO;
import it.contrader.service.DictionaryService;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class DictionaryController implements Controller {

	/**
	 * definisce il pacchetto di vista research.
	 */
	private static String sub_package = "dictionary.";
	
	private DictionaryService dictionaryService;
	/**
	 * Costruisce un oggetto di tipo ResearchService per poterne usare i metodi
	 */
	public DictionaryController() {
		this.dictionaryService = new DictionaryService();
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
		String name;

		switch (mode) {
		
		// Arriva qui dalla DictionaryReadView. Invoca il Service con il parametro id e invia alla DictionaryReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			DictionaryDTO dictionaryDTO = dictionaryService.read(id);
			request.put("dictionary", dictionaryDTO);
			MainDispatcher.getInstance().callView(sub_package + "DictionaryRead", request);
			break;
		
		// Arriva qui dalla DictionaryInsertView. Estrae i parametri da inserire e chiama il service per inserire un Dictionary con questi parametri
		case "INSERT":
			name = request.get("name").toString();
			
			//costruisce l'oggetto Dictionary da inserire
			DictionaryDTO dictionarytoinsert = new DictionaryDTO(name);
			//invoca il service
			dictionaryService.insert(dictionarytoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "DictionaryInsert", request);
			break;
		
		// Arriva qui dalla DictionaryDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			dictionaryService.delete(id);
			request = new Request();
			request.put("mode", "mode");			
			MainDispatcher.getInstance().callView(sub_package + "DictionaryDelete", request);
			break;
		
		// Arriva qui dalla DictionaryUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			DictionaryDTO dictionarytoupdate = new DictionaryDTO(name);
			dictionarytoupdate.setId(id);
			dictionaryService.update(dictionarytoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DictionaryUpdate", request);
			break;
			
		//Arriva qui dalla DictionaryView Invoca il Service e invia alla DictionaryView il risultato da mostrare 
		case "DICTIONARYLIST":
			List<DictionaryDTO> dictionariesDTO = dictionaryService.getAll();
			//Impacchetta la request con la lista dei dizionari
			request.put("dictionaries", dictionariesDTO);
			MainDispatcher.getInstance().callView("Dictionary", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "DictionaryRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "DictionaryInsert", null);
				break;
				
			case "M":
				
				System.out.println();
				List<DictionaryDTO> dicts = dictionaryService.getAll();
				for(DictionaryDTO d : dicts)
				{
					System.out.println(d);
				}
				System.out.println();
				
				MainDispatcher.getInstance().callView(sub_package + "DictionaryUpdate", null);
				break;
				
			case "C":
				
				System.out.println();
				List<DictionaryDTO> dic = dictionaryService.getAll();
				for(DictionaryDTO d : dic)
				{
					System.out.println(d);
				}
				System.out.println();
				
				MainDispatcher.getInstance().callView(sub_package + "DictionaryDelete", null);
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

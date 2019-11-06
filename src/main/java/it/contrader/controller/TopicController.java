package it.contrader.controller;

import it.contrader.main.MainDispatcher;
import java.util.List;

import it.contrader.dto.TopicDTO;
import it.contrader.service.TopicService;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class TopicController implements Controller {

	/**
	 * definisce il pacchetto di vista topic.
	 */
	private static String sub_package = "topic.";
	
	private TopicService topicService;
	/**
	 * Costruisce un oggetto di tipo topicService per poterne usare i metodi
	 */
	public TopicController() {
		this.topicService = new TopicService();
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
		
		// Arriva qui dalla TopicReadView. Invoca il Service con il parametro id e invia alla TopicReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			TopicDTO topicDTO = topicService.read(id);
			request.put("topic", topicDTO);
			MainDispatcher.getInstance().callView(sub_package + "TopicRead", request);
			break;
		
		// Arriva qui dalla TopicInsertView. Estrae i parametri da inserire e chiama il service per inserire un Topic con questi parametri
		case "INSERT":
			name = request.get("name").toString();
			
			//costruisce l'oggetto Topic da inserire
			TopicDTO topictoinsert = new TopicDTO(name);
			//invoca il service
			topicService.insert(topictoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "TopicInsert", request);
			break;
		
		// Arriva qui dalla TopicDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			topicService.delete(id);
			request = new Request();
			request.put("mode", "mode");			
			MainDispatcher.getInstance().callView(sub_package + "TopicDelete", request);
			break;
		
		// Arriva qui dalla TopicUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			TopicDTO topictoupdate = new TopicDTO(name);
			topictoupdate.setId(id);
			topicService.update(topictoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TopicUpdate", request);
			break;
			
		//Arriva qui dalla TopicView Invoca il Service e invia alla TopicView il risultato da mostrare 
		case "TOPICLIST":
			List<TopicDTO> topicsDTO = topicService.getAll();
			//Impacchetta la request con la lista dei dizionari
			request.put("topics", topicsDTO);
			MainDispatcher.getInstance().callView("Topic", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "TopicRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "TopicInsert", null);
				break;
				
			case "M":
				
				System.out.println();
				List<TopicDTO> dicts = topicService.getAll();
				for(TopicDTO t : dicts)
				{
					System.out.println(t);
				}
				System.out.println();
				
				MainDispatcher.getInstance().callView(sub_package + "TopicUpdate", null);
				break;
				
			case "C":
				
				System.out.println();
				List<TopicDTO> dic = topicService.getAll();
				for(TopicDTO t : dic)
				{
					System.out.println(t);
				}
				System.out.println();
				
				MainDispatcher.getInstance().callView(sub_package + "TopicDelete", null);
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
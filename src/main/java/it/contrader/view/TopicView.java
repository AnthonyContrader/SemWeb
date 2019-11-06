package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.TopicDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class TopicView extends AbstractView {

	private Request request;
	private String choice;

	public TopicView() {
		
	}

	/**
	 * Mostra la lista topics
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione topics ----------------\n");
			
			@SuppressWarnings("unchecked")
			List<TopicDTO> topics = (List<TopicDTO>) request.get("topics");
			for (TopicDTO t: topics)
				System.out.println(t);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi TopicController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
	}
	
	/**
	 * Impacchetta la request e la manda al TopicController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Topic", "doControl", this.request);
	}
}
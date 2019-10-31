package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.DictionaryDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class DictionaryView extends AbstractView {

	private Request request;
	private String choice;

	public DictionaryView() {
		
	}

	/**
	 * Mostra la lista dizionari
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione dizionari ----------------\n");
			
			@SuppressWarnings("unchecked")
			List<DictionaryDTO> dictionaries = (List<DictionaryDTO>) request.get("dictionaries");
			for (DictionaryDTO d: dictionaries)
				System.out.println(d);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi DictionaryController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
	}
	
	/**
	 * Impacchetta la request e la manda al DictionaryController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Dictionary", "doControl", this.request);
	}
}

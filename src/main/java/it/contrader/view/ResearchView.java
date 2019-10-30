package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ResearchDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class ResearchView extends AbstractView {

	private Request request;
	private String choice;

	public ResearchView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione ricerche ----------------\n");
			// System.out.println("ID\tUsername\tPassword\tTipo Utente");
			// System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<ResearchDTO> researches = (List<ResearchDTO>) request.get("researches");
			for (ResearchDTO r: researches)
				System.out.println(r);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda al ResearchController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Research", "doControl", this.request);
	}

}

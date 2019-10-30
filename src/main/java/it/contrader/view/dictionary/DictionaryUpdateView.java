package it.contrader.view.dictionary;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class DictionaryUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String name;
	private final String mode = "UPDATE";

	public DictionaryUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Dictionary", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del dizionario:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome del dizionario:");
			name = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Dictionary", "doControl", request);
	}

}

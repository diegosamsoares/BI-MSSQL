package managedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class CheckboxViewFiltros {

	private String[] selectedCities;
	private List<String> cities;
	private List<String> carteiras;

	@PostConstruct
	public void init() {
		cities = new ArrayList<String>();
		cities.add("AL");
		cities.add("BA");
		cities.add("CE");
		cities.add("PB");
		cities.add("PE");
		cities.add("RN");

		carteiras = new ArrayList<String>();
		carteiras.add("CARTEIRA");
		carteiras.add("CARTEIRA ACORDO");
		carteiras.add("COBRANCA C/ADVOGADO");
		carteiras.add("COBRANCA JUDICIAL");
		carteiras.add("COBRANCA SIMPLES");

	}

	public String[] getSelectedCities() {
		return selectedCities;
	}

	public void setSelectedCities(String[] selectedCities) {
		this.selectedCities = selectedCities;
	}

	public List<String> getCities() {
		return cities;
	}

	public List<String> getCarteiras() {
		return carteiras;
	}
}
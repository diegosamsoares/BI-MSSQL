package managedbeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import dao.GraficoDao;
import model.Venda;
import relatoriosgraficos.ConnectionFactory;

@ManagedBean
public class Graficos {

	private LineChartModel lineModel;

	LineChartModel model = new LineChartModel();
	LineChartSeries serie1 = new LineChartSeries();
	LineChartSeries serie2 = new LineChartSeries();
	LineChartSeries serie3 = new LineChartSeries();

	public LineChartModel getLineModel() {
		return lineModel;
	}

	@PostConstruct
	public void init() {
		criarLinhasModelo();
	}

	private LineChartModel iniciarModeloLinear() {// METODO QUE PEGA OS DADOS
													// QUE VEM DA DAO E JOGA NO
													// GRAFICO
		java.sql.Connection connection = new ConnectionFactory().getConnection();
		GraficoDao daoGraficos = new GraficoDao(connection);
		List<Venda> vendas = new ArrayList<Venda>();
		try {
			vendas = daoGraficos.listar(); // PERCORRENDO A LISTA QUE VEM DO DAO
			for (Venda venda : vendas) {
				int numeromes;
				double valormes;
				numeromes = venda.getMes();
				valormes = venda.getValor();
				serie1.getData().put(numeromes, valormes);// SETANDO OS DADOS DA
															// LISTA NO
															// COMPONENTE DO
															// GRAFICO
				serie2.set(1, 200);
				serie2.set(2, 300);
				serie2.set(3, 454);
				serie2.set(4, 2323);
				serie2.set(5, 667);
				serie2.set(6, 332);
				serie2.set(7, 678);
				serie2.set(8, 2233);
				serie2.set(9, 2500);
				serie2.set(10, 222);
				serie2.set(11, 555);
				serie2.set(12, 660);

				serie3.set(1, 200);
				serie3.set(2, 343);
				serie3.set(3, 676);
				serie3.set(4, 545);
				serie3.set(5, 544);
				serie3.set(6, 555);
				serie3.set(7, 333);
				serie3.set(8, 777);
				serie3.set(9, 999);
				serie3.set(10, 1123);
				serie3.set(11, 3333);
				serie3.set(12, 444);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		serie1.setLabel("Valores 1"); // BOTA O NOME NO GRAFICO
		serie2.setLabel("Valores 2");
		serie3.setLabel("Valores 3");
		model.addSeries(serie1);
		model.addSeries(serie2);
		model.addSeries(serie3);
		return model;
	}

	public void criarLinhasModelo() {
		lineModel = iniciarModeloLinear();
		lineModel.setTitle("Exemplo - Gráfico");
		lineModel.setLegendPosition("e");

		Axis yAxis = lineModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(5000);
		yAxis.setTickFormat("%d");
		yAxis.setLabel("Unidades");

		Axis xAxis = lineModel.getAxis(AxisType.X);
		xAxis.setMin(1);
		xAxis.setMax(12);
		xAxis.setTickFormat("%d");
		xAxis.setLabel("Meses");

	}

}

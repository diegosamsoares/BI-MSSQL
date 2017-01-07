package relatoriosgraficos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.GraficoDao;
import model.Venda;

public class TESTADORA {

	public static void main(String[] args) throws SQLException {
	

		Connection connection = new ConnectionFactory().getConnection();
		GraficoDao daoGraficos = new GraficoDao(connection);
		List<Venda>vendas= daoGraficos.listar();
		for (Venda venda : vendas) {
			System.out.println(venda.getValor()+" data:"+ venda.getMes());
		}
	
		   
		   
		   
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sun.faces.facelets.tag.jstl.core.ForEachHandler;

import model.Venda;

public class GraficoDao {

	public Connection conexao;

	public GraficoDao(Connection connection) {
		this.conexao = connection;
	}

	public List<Venda> listar() throws SQLException {
		PreparedStatement pStatement = conexao
				.prepareStatement("select MONTH(data) data , sum(valor) valor from vendas  GROUP BY MONTH(data)");
		List<Venda> vendas = new ArrayList<Venda>();
		ResultSet rs = pStatement.executeQuery();
		while (rs.next()) {

			int mes = rs.getInt("data");
			double valor = rs.getDouble("valor");
			Venda venda = new Venda();
			venda.setValor(valor);
			venda.setMes(mes);
			vendas.add(venda);

		}
		rs.close();
		pStatement.close();
		return vendas;

	}

}

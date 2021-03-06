package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/buscaEmpresa")
public class BuscaEmpresa extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO()
				.buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
		dispatcher.forward(req, resp);

	}
}

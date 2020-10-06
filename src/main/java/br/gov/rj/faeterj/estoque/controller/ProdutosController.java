package br.gov.rj.faeterj.estoque.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.rj.faeterj.estoque.model.Produto;

@Controller
public class ProdutosController {
	// (1) Método que devolve o nome da view
	// e para o DispatcherServlet encontrar o controller
	// ele deverá estar mapeado
	@RequestMapping("/produtos/novo") // Configurando a URL
	public String novo() {
		return "produto/CadastroProduto"; // Retorno do nome da view
	}
	// A partir deste controller será possível renderizar o HTML
	
	@RequestMapping(value = "/produtos/novo", method = RequestMethod.POST)
	public  String cadastrar(@Valid Produto produto, BindingResult result,
			Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute("mensagem","Erro no formulário");
			return "produto/CadastroProduto";
		}
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso");
		System.out.println("SKU >>>>>:" + produto.getSku());
		return "redirect:/produtos/novo";
	}
	
}

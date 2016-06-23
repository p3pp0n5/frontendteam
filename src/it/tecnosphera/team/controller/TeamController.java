package it.tecnosphera.team.controller;

import it.tecnosphera.team.business.TeamInterface;
import it.tecnosphera.team.entity.Team;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeamController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		Team team = null;
		try {
			Context ctx = new InitialContext();
			//TeamInterface teamInterface = (TeamInterface) ctx.lookup("it.tecnosphera.team.business.TeamInterface");
			TeamInterface teamInterface = (TeamInterface) ctx.lookup("java:global/EAR/Back-end/TeamImplementation");
			team = teamInterface.getTeam();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("team", team);
		return "ciao";
	}
}

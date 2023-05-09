/*
package pgfn.gov.transfer.services.exceptions;

import com.file.transfer.entities.UsuarioEntity;
import com.file.transfer.repositories.UsuarioRepository;
import com.file.transfer.security.UserSS;
import com.file.transfer.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.logging.Logger;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	private static final Logger log = Logger.getLogger(CustomAccessDeniedHandler.class.getName());

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Transactional
	public UsuarioEntity getUserLogado() {

		@SuppressWarnings("static-access")
		UserSS user = usuarioService.authenticated();

		return usuarioRepository.findByCpf(user.getCpf());
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exc)
			throws IOException, ServletException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			log.warning("---------Usuario não autorizado--------" + getUserLogado());
		}

		response.sendRedirect(request.getContextPath() + "/accessDenied");
	}
}*/

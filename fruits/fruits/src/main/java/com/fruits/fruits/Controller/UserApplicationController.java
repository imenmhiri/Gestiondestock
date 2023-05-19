package com.fruits.fruits.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.fruits.fruits.Entity.User;
import com.fruits.fruits.Model.ApiResponse;
import com.fruits.fruits.Model.AuthenticateRequest;
import com.fruits.fruits.Model.RequestSignup;
import com.fruits.fruits.Service.UserDetail;

@RestController 
@CrossOrigin(origins = "*")
@RequestMapping(path = "/userapp")
public class UserApplicationController {
	
	@Autowired
    private UserDetail js;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/creercompte", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@Valid @RequestBody RequestSignup signUpRequest) {
		//Pour verifer si deja l'utilisateur est inscrit à l'application ou non 
		
		User user1=js.findByEmail(signUpRequest.getEmail()); 
 	    if (user1!=null) {
 		   return ResponseEntity
	                  .badRequest()
	                  .body("user existant!");
 	   }
 	   // sinon creer le nouveau utilistaeur 
 	   js.saveUser(signUpRequest);
       	   return ResponseEntity.ok(new ApiResponse(true, " sucess"));
	     
	}
	
	//pour que l'utlisateur puisse se connecter 
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateRequest authenticationRequest) throws Exception {
	  authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
	  User user=js.findByEmail(authenticationRequest.getEmail()); 
	  if(user.getEmail()!="") {
			   return ResponseEntity.ok(new ApiResponse(true , "sucess"));
			}
			   return ResponseEntity.badRequest().body("email inexistant !");
		}
    
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	 	 		
}
	    



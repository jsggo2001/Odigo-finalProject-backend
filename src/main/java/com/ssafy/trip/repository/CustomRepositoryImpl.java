package com.ssafy.trip.repository;

import com.ssafy.trip.domain.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CustomRepositoryImpl implements CustomRepository {

	@NonNull
	private final EntityManager em;
	
	@Override
	public void customSave(User user) {em.persist(user);}
	
	@Override
	public User customFindOne(Long id) {
		return em.find(User.class, id);
	}
	
	@Override
	public List<User> customFindAll(){
		return em.createQuery(("select u from User u"), User.class)
				.getResultList();
	}



	@Override
	public User customGetUser(String loginId) { // login
		log.info("loginId {}", loginId);
		return em.createQuery(("select u from User u where u.loginId = :login_id"), User.class)
				.setParameter("login_id", loginId)
				.getSingleResult();
	}
	
	
	@Override
	public List<User> customGetUserByName(String loginId) { // login
		return em.createQuery(("select u from User u where u.loginId = :login_id"), User.class)
				.setParameter("login_id", loginId)
				.getResultList();
	}
}

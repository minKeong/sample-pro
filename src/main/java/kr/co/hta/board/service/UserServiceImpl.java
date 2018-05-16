package kr.co.hta.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hta.board.dao.UserDao;
import kr.co.hta.board.exception.SimpleBoardException;
import kr.co.hta.board.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void addNewUser(User user) {
		// 같은 아이디를 가진 사용자가 존재하면 db에 입력 데이터를 넣지 않는다
		List<User> users = userDao.searchUsers(user.getId());
		if (!users.isEmpty() ) {
			throw new SimpleBoardException("입력한 아이디가 이미 존재합니다");
		}
		userDao.addUser(user);
	}

	@Override
	public User getUserDetail(String userId) {
		User user = userDao.getUserById(userId);
		return user;
	}
	
}
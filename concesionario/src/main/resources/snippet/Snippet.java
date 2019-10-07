package snippet;

public class Snippet {
	UserEntity userEntity = userRepository.findById(idUser).get();
	return carRepository.findByUserEntity(pageable, userEntity);
}


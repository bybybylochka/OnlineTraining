package by.bsuir.onlinetraining.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Long entityId, Class<?> entityClass) {
        super(String.format("%s with id %s was not found!", entityClass.getName(), entityId));
    }
}

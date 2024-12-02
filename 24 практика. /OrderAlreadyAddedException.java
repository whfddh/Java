// Исключение при попытке добавить заказ, если уже связан с адресом или столиком
class OrderAlreadyAddedException extends RuntimeException {
    public OrderAlreadyAddedException(String message) {
        super(message);
    }
}

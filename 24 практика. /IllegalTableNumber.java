// Исключение для случая недопустимого номера столика
class IllegalTableNumber extends RuntimeException {
    public IllegalTableNumber(String message) {
        super(message);
    }
}

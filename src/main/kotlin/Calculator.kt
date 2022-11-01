

class Calculator {

    fun add(first: Int, second: Int): Int{
        return first + second
    }

    fun divide(first: Int, second: Int): Int{
        if(second == 0){
            throw IllegalArgumentException("Cannot divide by zero")
        } else {
            return first / second
        }

    }


}
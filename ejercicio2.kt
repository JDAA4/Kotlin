fun main() {
    clima("Ankara",27,31,82)
    clima("Tokyo",32,36,10)
    clima("Cape town", 59,64,2)
    clima("Guatemala City",50,55,7)
}

fun clima(city : String, lt : Int, ht : Int, humedity : Int){
    println("City: $city\nLow temperature: $lt, High temperature: $ht\nChance of rain: $humedity%\n")
}

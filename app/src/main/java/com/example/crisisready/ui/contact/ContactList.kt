package com.example.crisisready.ui.contact
import org.json.JSONObject
val jsonString = """
        {
            "National Emergency Number": "112",
            "Police": "100",
            "Fire": "101",
            "Ambulance": "102",
            "Disaster Management Services": "108",
            "Women Helpline": "1091",
            "Anti-Poison": "1066",
            "Road Accident Emergency Service": "1073",
            "Children in Difficult Situations": "1098",
            "Tourist Helpline": "1363 or 1800111363",
            "LPG Leak Helpline": "1906",
            "Medical Helpline": "108",
            "Air Ambulance": "9540161344",
            "Earthquake/Flood/Disaster (NDRF Headquarters)": "011-24363260, 9711077372",
            "Relief Commissioner for Natural Calamities": "1070",
            "Central Vigilance Commission": "1964",
            "ORBO Centre, AIIMS": "1060"
        }
    """.trimIndent()


fun jsonToMapList(jsonString: String): Map<String, List<String>> {
    val resultMap = mutableMapOf<String, List<String>>()
    val jsonObject = JSONObject(jsonString)

    jsonObject.keys().forEach { key ->
        val value = jsonObject.getString(key)

        // Split by commas, "or", and whitespace, and filter out empty strings
        val numbers = value.split(",", "or", " ").map { it.trim() }.filter { it.isNotEmpty() }

        resultMap[key] = numbers
    }

    return resultMap
}
val contactList = jsonToMapList(jsonString)
//val contactList = mapOf(
//    "Police" to listOf("100", "101", "102"),
//    "Fire Department" to listOf("101", "102", "103"),
//    "Ambulance" to listOf("102", "103", "104"),
//    "Evacuation" to listOf("103", "104", "105"),
//    "Shelter" to listOf("104", "105", "106"),
//    "Emergency Medical Services (EMS)" to listOf("10643"),
//    "National Emergency Services (NES)" to listOf("1634"),
//    "National Disaster Management Agency (NDMA)" to listOf("2643"),
//    "Flood Helpline" to listOf("3643"),
//    "Earthquake Relief Helpline" to listOf("43461"),
//    "Cyclone Warning Center" to listOf("564321"),
//)
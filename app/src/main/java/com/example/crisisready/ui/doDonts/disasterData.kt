package com.example.crisisready.ui.doDonts

import com.example.crisisready.R


//val disasterGuidelines: Map<String, Map<String, List<String>>> = mapOf(
//    "Thunderstorm" to mapOf(
//        "Do's" to listOf(
//            "Stay Indoors.",
//            "Avoid natural lightning rods.",
//            "Stay away from large groups."
//        ),
//        "Don'ts" to listOf(
//            "Do not keep contact with electrical items.",
//            "Do not keep contact with metal surfaces.",
//            "Keep animals under control."
//        ),
//        "Before" to listOf(
//            "Prepare an emergency kit with essential items for safety and survival.",
//            "Secure your house; carry out repairs; don't leave sharp objects loose.",
//            "Secure outside objects that could blow away and cause damage.",
//            "Remove rotting trees/broken branches that could fall and cause injury or damage.",
//            "Listen to radio, watch TV or read newspapers for weather updates and warnings."
//        ),
//        "During" to listOf(
//            "Keep a watch on local weather updates and warnings.",
//            "Try to stay indoors; stay off verandas.",
//            "Unplug all electrical equipment. Don't use corded telephones. Use your battery-operated radio for news updates.",
//            "Don't touch plumbing and metal pipes. Do not use running water.",
//            "Stay away from structures with tin roofs/metal sheets.",
//            "Don't take shelter near/under trees.",
//            "Stay put if you are inside a car/bus/covered vehicle.",
//            "Don't use metallic objects; stay away from power/telephone lines.",
//            "Get out of water - pools, lakes, small boats on water bodies and take safe shelter immediately.",
//            "Remember, rubber-soled shoes and rubber tires provide NO protection from lightning.",
//            "Avoid rubbing your eyes in order to prevent eye infection, which is common during this season.",
//            "Apply a small amount of petroleum jelly to the inside of the nostrils to prevent drying of your mucous membranes."
//        ),
//        "After" to listOf(
//            "Stay away from storm-damaged areas.",
//            "Listen to local radio/TV stations for updated information or instructions on weather and traffic updates.",
//            "Help children, women, elderly, and differently-abled.",
//            "Stay away from fallen trees/power lines and report them to nearest Tehsil/District HQ immediately."
//        ),
//        "For Animals" to listOf(
//            "Designate a safe area in or near your house to shelter your animals in a severe thunderstorm.",
//            "Keep your animals away from open water, pond, or river.",
//            "Keep your animals away from tractors and other metal farm equipment.",
//            "Don't allow your animals to congregate under trees.",
//            "Watch your animals closely and try to keep them under your direct control."
//        )
//    ),
//    "Earthquake" to mapOf(
//        "Do's" to listOf(
//            "Identify safe places indoors and outdoors.",
//            "Move away from buildings, utility wires, etc.",
//            "Place large or heavy objects on lower shelves."
//        ),
//        "Don'ts" to listOf(
//            "Do not keep mouth uncovered.",
//            "Do not operate electrical appliances.",
//            "Do not light a match."
//        ),
//        "Before" to listOf(
//            "Consult a structural engineer to make your house earthquake resilient.",
//            "Know your seismic zone and carry out necessary structural changes in your house.",
//            "Preserve the design and layout drawings of your house for future reference.",
//            "Repair deep plaster cracks on walls and ceilings.",
//            "Fasten shelves securely to walls; place heavy/large objects on lower shelves. Provide strong support to power and gas appliances.",
//            "Prepare an emergency kit with essential items for safety and survival.",
//            "Develop an emergency communication and evacuation plan for your family.",
//            "Learn the technique of 'Drop-Cover-Hold'.",
//            "Avoid flood plains and filled-up areas for construction as far as possible.",
//            "Educate yourself and family members about earthquake risk."
//        ),
//        "During" to listOf(
//            "Stay calm. Do Not Panic. If you're indoors, stay inside. If you're outside, stay outside.",
//            "Don't use matches, candles, or any flame. Broken gas lines and fire don't mix.",
//            "If you're in a car, stop the car and stay inside until the earthquake stops.",
//            "Drop under a table; Cover your head with one hand and Hold the table till the tremors last.",
//            "Stay away from mirrors and windows. Do not exit the building while the earth is still shaking.",
//            "Move outside as soon as the tremors stop. Do not use a lift.",
//            "When outside, move away from buildings, trees, walls and poles/electric lines.",
//            "When inside a vehicle, pull over in an open place and remain inside; avoid bridges.",
//            "When in a structurally safe building, stay inside until shaking stops.",
//            "Protect yourself by staying in the corner/ under a strong table or bed/ an inside wall away from mirrors and windows.",
//            "If near an exit, leave the building as soon as possible.",
//            "If inside an old and weak structure, take the fastest and safest way out."
//        ),
//        "After" to listOf(
//            "Do not enter damaged buildings.",
//            "If trapped in rubble:",
//            "- Do not light a matchstick.",
//            "- Cover your mouth with a cloth.",
//            "- Tap on a pipe or a wall.",
//            "- Sound a whistle.",
//            "- Shout only as a last resort. This will help you conserve energy.",
//            "Use stairs and not lifts or elevators.",
//            "Move cautiously, and check for unstable objects and other hazards above and around you. Check yourself for injuries.",
//            "Anticipate aftershocks, especially after a major earthquake.",
//            "Stay away from beaches. Tsunamis and seiches sometimes hit after the ground has stopped shaking.",
//            "Do not spread and/ or believe in rumours.",
//            "Leave a message stating where you are going if you must evacuate your house.",
//            "Do not drive around the damaged areas as rescue and relief operations need roads for mobility.",
//            "Do not attempt to cross bridges/flyovers, which may have been damaged."
//        )
//    ), "Flood" to mapOf(
//        "Do's" to listOf(
//            "Move to higher ground immediately.",
//            "Turn off utilities like gas, electricity, and water.",
//            "Use local alerts and warning systems to stay informed."
//        ),
//        "Don'ts" to listOf(
//            "Do not walk, swim, or drive through floodwaters.",
//            "Avoid bridges over fast-moving water.",
//            "Do not touch electrical equipment if you are wet."
//        ),
//        "Before" to listOf(
//            "Know your flood risk and make an evacuation plan.",
//            "Secure your home; consider flood insurance.",
//            "Prepare an emergency kit with essential items."
//        ),
//        "During" to listOf(
//            "Evacuate immediately if advised by authorities.",
//            "Move to higher ground or the highest floor if trapped.",
//            "Avoid floodwaters, as they can be contaminated or electrically charged."
//        ),
//        "After" to listOf(
//            "Avoid flood-damaged areas.",
//            "Wear protective clothing when cleaning up.",
//            "Document damage for insurance purposes."
//        )
//    ),
//    "Cyclone" to mapOf(
//        "Do's" to listOf(
//            "Listen to weather warnings and evacuate if advised.",
//            "Secure outdoor objects that could become projectiles.",
//            "Reinforce doors and windows to prevent breakage."
//        ),
//        "Don'ts" to listOf(
//            "Do not go outside until the cyclone has fully passed.",
//            "Avoid using electrical appliances during the storm.",
//            "Do not stay in mobile homes or temporary shelters."
//        ),
//        "Before" to listOf(
//            "Prepare an emergency kit with food, water, and medical supplies.",
//            "Create a family communication plan.",
//            "Secure your home and remove loose objects from your yard."
//        ),
//        "During" to listOf(
//            "Stay indoors and keep away from windows.",
//            "Take shelter in a small, windowless room if the wind becomes intense.",
//            "Unplug electrical appliances to avoid power surges."
//        ),
//        "After" to listOf(
//            "Stay informed about emergency updates.",
//            "Avoid downed power lines and flooded areas.",
//            "Check for structural damage before re-entering your home."
//        )
//    ),
//    "Landslide" to mapOf(
//        "Do's" to listOf(
//            "Move away from the path of the landslide.",
//            "Listen to weather warnings and prepare to evacuate.",
//            "Stay alert to any sudden changes in your surroundings."
//        ),
//        "Don'ts" to listOf(
//            "Do not return to the area until authorities say it's safe.",
//            "Avoid river valleys and low-lying areas during heavy rain.",
//            "Do not drive during intense rainfall if a landslide is likely."
//        ),
//        "Before" to listOf(
//            "Learn about the risk of landslides in your area.",
//            "Prepare an emergency kit and evacuation plan.",
//            "Stay informed about weather conditions that could trigger landslides."
//        ),
//        "During" to listOf(
//            "Stay alert to changes in the landscape.",
//            "Move to higher ground if you see signs of a landslide.",
//            "Evacuate immediately if you hear rumbling or unusual sounds."
//        ),
//        "After" to listOf(
//            "Stay away from the landslide area until it's declared safe.",
//            "Check for injured or trapped people near the slide.",
//            "Report broken utility lines or other hazards to authorities."
//        )
//    ),
//    "Tsunami" to mapOf(
//        "Do's" to listOf(
//            "Move to higher ground immediately if you feel an earthquake near the coast.",
//            "Listen to local authorities for evacuation orders.",
//            "Stay away from the coast until all tsunami waves have passed."
//        ),
//        "Don'ts" to listOf(
//            "Do not stay in low-lying coastal areas after a strong earthquake.",
//            "Do not return to the coast until officials say it's safe.",
//            "Do not go near the beach to watch the tsunami waves."
//        ),
//        "Before" to listOf(
//            "Know the tsunami evacuation routes in your area.",
//            "Prepare an emergency kit with food, water, and medical supplies.",
//            "Stay informed about tsunami risks and warnings."
//        ),
//        "During" to listOf(
//            "Evacuate immediately if you are in a tsunami evacuation zone.",
//            "Move to higher ground or as far inland as possible.",
//            "Avoid rivers and streams that lead to the ocean."
//        ),
//        "After" to listOf(
//            "Stay away from the coast until authorities declare it safe.",
//            "Avoid disaster areas to allow emergency response teams to work.",
//            "Check yourself for injuries and get first aid if necessary."
//        )
//    ),
//    "Heat Wave" to mapOf(
//        "Do's" to listOf(
//            "Stay hydrated by drinking plenty of water.",
//            "Wear lightweight, light-colored, and loose-fitting clothing.",
//            "Stay indoors during the hottest part of the day."
//        ),
//        "Don'ts" to listOf(
//            "Do not leave children or pets in parked cars.",
//            "Avoid strenuous activities during peak heat.",
//            "Do not consume alcohol or caffeine in excessive amounts."
//        ),
//        "Before" to listOf(
//            "Know the signs of heat-related illnesses like heat exhaustion and heatstroke.",
//            "Check weather forecasts and prepare for high temperatures.",
//            "Plan to stay in cool places during the heatwave."
//        ),
//        "During" to listOf(
//            "Stay cool by taking frequent breaks in air-conditioned environments.",
//            "Use fans and wear wet clothing to cool down.",
//            "Seek immediate medical attention if you or someone else shows signs of heatstroke."
//        ),
//        "After" to listOf(
//            "Continue to stay hydrated and cool.",
//            "Check on neighbors, especially the elderly and vulnerable.",
//            "Avoid using heat-producing appliances until temperatures drop."
//        )
//    ),
//    "Fire" to mapOf(
//        "Do's" to listOf(
//            "Know the fire escape routes in your home and workplace.",
//            "Install smoke detectors and test them regularly.",
//            "Keep a fire extinguisher in accessible locations."
//        ),
//        "Don'ts" to listOf(
//            "Do not leave cooking unattended.",
//            "Avoid overloading electrical circuits.",
//            "Do not block exits with furniture or clutter."
//        ),
//        "Before" to listOf(
//            "Develop a fire escape plan and practice it regularly.",
//            "Check for fire hazards in your home and make necessary repairs.",
//            "Store flammable materials safely."
//        ),
//        "During" to listOf(
//            "Get low to the ground to avoid smoke inhalation.",
//            "Use the back of your hand to check doors for heat before opening.",
//            "If your clothes catch fire, stop, drop, and roll."
//        ),
//        "After" to listOf(
//            "Do not re-enter a burning building.",
//            "Get medical treatment for burns or smoke inhalation.",
//            "Check your home for hidden fire damage and smoke contamination."
//        )
//    ),
//    "Forest Fire" to mapOf(
//        "Do's" to listOf(
//            "Evacuate immediately if advised by authorities.",
//            "Keep windows and doors closed to prevent smoke from entering.",
//            "Stay tuned to local news for evacuation updates."
//        ),
//        "Don'ts" to listOf(
//            "Do not leave your property if not ordered to evacuate.",
//            "Avoid driving through heavy smoke or flames.",
//            "Do not use flammable materials or equipment outdoors."
//        ),
//        "Before" to listOf(
//            "Create a defensible space around your home by clearing flammable vegetation.",
//            "Prepare an emergency kit with essential supplies.",
//            "Stay informed about fire risks and evacuation plans."
//        ),
//        "During" to listOf(
//            "Follow evacuation orders promptly and take your emergency kit.",
//            "Close all windows, doors, and vents to prevent embers from entering.",
//            "Keep a flashlight and radio with you to stay informed."
//        ),
//        "After" to listOf(
//            "Return home only when authorities say it is safe.",
//            "Wear protective clothing and a mask when inspecting your property.",
//            "Report any hot spots or smoldering areas to the fire department."
//        )
//    ),
//    "Drought" to mapOf(
//        "Do's" to listOf(
//            "Conserve water by fixing leaks and using water-efficient appliances.",
//            "Reuse water whenever possible, such as collecting rainwater for irrigation.",
//            "Stay informed about local water restrictions and follow them."
//        ),
//        "Don'ts" to listOf(
//            "Do not waste water on non-essential activities.",
//            "Avoid washing cars or watering lawns during peak drought conditions.",
//            "Do not plant water-intensive crops during drought periods."
//        ),
//        "Before" to listOf(
//            "Install water-saving fixtures and appliances.",
//            "Plan and plant a drought-resistant landscape.",
//            "Stock up on water in case of supply interruptions."
//        ),
//        "During" to listOf(
//            "Use water only for essential purposes.",
//            "Follow local restrictions and guidelines for water use.",
//            "Educate others about the importance of water conservation."
//        ),
//        "After" to listOf(
//            "Continue practicing water conservation.",
//            "Prepare for potential after-effects, such as wildfires.",
//            "Check for any long-term damage to plants and infrastructure."
//        )
//    )
//)

val disasterGuidelines = mapOf(
    "Thunderstorm" to mapOf(
        "Do's" to listOf(
            R.string.thunderstorm_dos_1,
            R.string.thunderstorm_dos_2,
            R.string.thunderstorm_dos_3
        ),
        "Don'ts" to listOf(
            R.string.thunderstorm_donts_1,
            R.string.thunderstorm_donts_2,
            R.string.thunderstorm_donts_3
        ),
        "Before" to listOf(
            R.string.thunderstorm_before_1,
            R.string.thunderstorm_before_2,
            R.string.thunderstorm_before_3,
            R.string.thunderstorm_before_4,
            R.string.thunderstorm_before_5
        ),
        "During" to listOf(
            R.string.thunderstorm_during_1,
            R.string.thunderstorm_during_2,
            R.string.thunderstorm_during_3,
            R.string.thunderstorm_during_4,
            R.string.thunderstorm_during_5,
            R.string.thunderstorm_during_6,
            R.string.thunderstorm_during_7,
            R.string.thunderstorm_during_8,
            R.string.thunderstorm_during_9,
            R.string.thunderstorm_during_10,
            R.string.thunderstorm_during_11,
            R.string.thunderstorm_during_12
        ),
        "After" to listOf(
            R.string.thunderstorm_after_1,
            R.string.thunderstorm_after_2,
            R.string.thunderstorm_after_3,
            R.string.thunderstorm_after_4
        ),
    ),
    "Earthquake" to mapOf(
        "Do's" to listOf(
            R.string.earthquake_dos_1,
            R.string.earthquake_dos_2,
            R.string.earthquake_dos_3
        ),
        "Don'ts" to listOf(
            R.string.earthquake_donts_1,
            R.string.earthquake_donts_2,
            R.string.earthquake_donts_3
        ),
        "Before" to listOf(
            R.string.earthquake_before_1,
            R.string.earthquake_before_2,
            R.string.earthquake_before_3,
            R.string.earthquake_before_4,
            R.string.earthquake_before_5,
            R.string.earthquake_before_6,
            R.string.earthquake_before_7,
            R.string.earthquake_before_8,
            R.string.earthquake_before_9,
            R.string.earthquake_before_10
        ),
        "During" to listOf(
            R.string.earthquake_during_1,
            R.string.earthquake_during_2,
            R.string.earthquake_during_3,
            R.string.earthquake_during_4,
            R.string.earthquake_during_5,
            R.string.earthquake_during_6,
            R.string.earthquake_during_7,
            R.string.earthquake_during_8,
            R.string.earthquake_during_9,
            R.string.earthquake_during_10,
            R.string.earthquake_during_11,
            R.string.earthquake_during_12
        ),
        "After" to listOf(
            R.string.earthquake_after_1,
            R.string.earthquake_after_2,
            R.string.earthquake_after_3,
            R.string.earthquake_after_4,
            R.string.earthquake_after_5,
            R.string.earthquake_after_6,
            R.string.earthquake_after_7,
            R.string.earthquake_after_8,
            R.string.earthquake_after_9,
            R.string.earthquake_after_10
        )
    ),
    "Flood" to mapOf(
        "Do's" to listOf(
            R.string.flood_dos_1,
            R.string.flood_dos_2,
            R.string.flood_dos_3
        ),
        "Don'ts" to listOf(
            R.string.flood_donts_1,
            R.string.flood_donts_2,
            R.string.flood_donts_3
        ),
        "Before" to listOf(
            R.string.flood_before_1,
            R.string.flood_before_2,
            R.string.flood_before_3
        ),
        "During" to listOf(
            R.string.flood_during_1,
            R.string.flood_during_2,
            R.string.flood_during_3
        ),
        "After" to listOf(
            R.string.flood_after_1,
            R.string.flood_after_2,
            R.string.flood_after_3
        )
    ),
    "Cyclone" to mapOf(
        "Do's" to listOf(
            R.string.cyclone_dos_1,
            R.string.cyclone_dos_2,
            R.string.cyclone_dos_3
        ),
        "Don'ts" to listOf(
            R.string.cyclone_donts_1,
            R.string.cyclone_donts_2,
            R.string.cyclone_donts_3
        ),
        "Before" to listOf(
            R.string.cyclone_before_1,
            R.string.cyclone_before_2,
            R.string.cyclone_before_3
        ),
        "During" to listOf(
            R.string.cyclone_during_1,
            R.string.cyclone_during_2,
            R.string.cyclone_during_3
        ),
        "After" to listOf(
            R.string.cyclone_after_1,
            R.string.cyclone_after_2,
            R.string.cyclone_after_3
        )
    ),
    "Landslide" to mapOf(
        "Do's" to listOf(
            R.string.landslide_dos_1,
            R.string.landslide_dos_2,
            R.string.landslide_dos_3
        ),
        "Don'ts" to listOf(
            R.string.landslide_donts_1,
            R.string.landslide_donts_2,
            R.string.landslide_donts_3
        ),
        "Before" to listOf(
            R.string.landslide_before_1,
            R.string.landslide_before_2,
            R.string.landslide_before_3
        ),
        "During" to listOf(
            R.string.landslide_during_1,
            R.string.landslide_during_2,
            R.string.landslide_during_3
        ),
        "After" to listOf(
            R.string.landslide_after_1,
            R.string.landslide_after_2,
            R.string.landslide_after_3
        )
    ),
    "Tsunami" to mapOf(
        "Do's" to listOf(
            R.string.tsunami_dos_1,
            R.string.tsunami_dos_2,
            R.string.tsunami_dos_3
        ),
        "Don'ts" to listOf(
            R.string.tsunami_donts_1,
            R.string.tsunami_donts_2,
            R.string.tsunami_donts_3
        ),
        "Before" to listOf(
            R.string.tsunami_before_1,
            R.string.tsunami_before_2,
            R.string.tsunami_before_3
        ),
        "During" to listOf(
            R.string.tsunami_during_1,
            R.string.tsunami_during_2,
            R.string.tsunami_during_3
        ),
        "After" to listOf(
            R.string.tsunami_after_1,
            R.string.tsunami_after_2,
            R.string.tsunami_after_3
        )
    ),
    "Heat Wave" to mapOf(
        "Do's" to listOf(
            R.string.heat_wave_dos_1,
            R.string.heat_wave_dos_2,
            R.string.heat_wave_dos_3
        ),
        "Don'ts" to listOf(
            R.string.heat_wave_donts_1,
            R.string.heat_wave_donts_2,
            R.string.heat_wave_donts_3
        ),
        "Before" to listOf(
            R.string.heat_wave_before_1,
            R.string.heat_wave_before_2,
            R.string.heat_wave_before_3
        ),
        "During" to listOf(
            R.string.heat_wave_during_1,
            R.string.heat_wave_during_2,
            R.string.heat_wave_during_3
        ),
        "After" to listOf(
            R.string.heat_wave_after_1,
            R.string.heat_wave_after_2,
            R.string.heat_wave_after_3
        )
    ),
    "Fire" to mapOf(
        "Do's" to listOf(
            R.string.fire_dos_1,
            R.string.fire_dos_2,
            R.string.fire_dos_3
        ),
        "Don'ts" to listOf(
            R.string.fire_donts_1,
            R.string.fire_donts_2,
            R.string.fire_donts_3
        ),
        "Before" to listOf(
            R.string.fire_before_1,
            R.string.fire_before_2,
            R.string.fire_before_3
        ),
        "During" to listOf(
            R.string.fire_during_1,
            R.string.fire_during_2,
            R.string.fire_during_3
        ),
        "After" to listOf(
            R.string.fire_after_1,
            R.string.fire_after_2,
            R.string.fire_after_3
        )
    ),
    "Forest Fire" to mapOf(
        "Do's" to listOf(
            R.string.forest_fire_dos_1,
            R.string.forest_fire_dos_2,
            R.string.forest_fire_dos_3
        ),
        "Don'ts" to listOf(
            R.string.forest_fire_donts_1,
            R.string.forest_fire_donts_2,
            R.string.forest_fire_donts_3
        ),
        "Before" to listOf(
            R.string.forest_fire_before_1,
            R.string.forest_fire_before_2,
            R.string.forest_fire_before_3
        ),
        "During" to listOf(
            R.string.forest_fire_during_1,
            R.string.forest_fire_during_2,
            R.string.forest_fire_during_3
        ),
        "After" to listOf(
            R.string.forest_fire_after_1,
            R.string.forest_fire_after_2,
            R.string.forest_fire_after_3
        )
    ),
    "Drought" to mapOf(
        "Do's" to listOf(
            R.string.drought_dos_1,
            R.string.drought_dos_2,
            R.string.drought_dos_3
        ),
        "Don'ts" to listOf(
            R.string.drought_donts_1,
            R.string.drought_donts_2,
            R.string.drought_donts_3
        ),
        "Before" to listOf(
            R.string.drought_before_1,
            R.string.drought_before_2,
            R.string.drought_before_3
        ),
        "During" to listOf(
            R.string.drought_during_1,
            R.string.drought_during_2,
            R.string.drought_during_3
        ),
        "After" to listOf(
            R.string.drought_after_1,
            R.string.drought_after_2,
            R.string.drought_after_3
        )
    )
)

package com.example.crisisready.ui.safetyTips

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//val safetyTipsList: Map<String, String> =
//    mapOf(
//        "pi_nUPcQz_A" to "How To Survive Floods? | Preparing For A Flood ",
//        "MllUVQM3KVk" to "How To Survive An Earthquake? | Earthquake Safety Tips",
//        "Xgc90CoJbDI" to "How To Survive A House Fire ? | Fire Safety Education",
//        "B9qR2e3xyJo" to "What To Do Before & During A Cyclone ?"
//    )
val jsonString = """{
        "cyclones": {
        "B9qR2e3xyJo": "What To Do Before & During A Cyclone ? | NDMA",
        "CcvOhT7n3y8": "What To Do If You're Outdoors During A Cyclone | NDMA",
        "Gm9c9EehO2g": "Secure Your House | NDMA",
        "xNwo_a57KGc": "Safety From Cyclones While Being Indoors | NDMA",
        "jXEDxQzVFSs": "Early Warning and Response | NDMA",
        "QP6PhMQN7-4": "Safety Tips For Fishermen | NDMA",
        "QsHXeOrNtmY": "Emergency Preparedness for Hurricanes in ASL"
    },
        "tsunamies": {
        "wCpjaXPc3eI": "NDMA INDIA - Tsunami (are you ready)",
        "W7GHpxHpnzk": "NDMA INDIA Tsunami (Dost Appu- Hindi)",
        "NEG3badyEJc": "World Tsunami Awareness Day 2018: Helping the Most Vulnerable [With sign language]"
    },
        "avalanche": {
        "3Q7fYDTL3dM": "If you get caught in an avalanche, don't panic, take these steps to survive!",
        "oJYmZu4Cl_E": "Know the signs of avalanche through this video.",
        "o60nTPTrzW8": "What is an Avalanche? - ASL"
    },
        "heatwave": {
        "PndkLH1tTWQ": "How To Keep Your House Cool During Summers? | NDMA",
        "W1iqMZC5gUk": "How To Reduce The Impact Of A Heatwave In Cities? | NDMA",
        "qBVXhX_xbYQ": "How Nomads And Homeless Can Be Helped During A Heatwave?",
        "WjUrCh3D0yA": "How Can Outdoor Workers & Labourers Protect Themselves? | NDMA",
        "Mka1BKsrBF4": "How To Keep Your Cities Cool During Summers | NDMA",
        "dWd_hDfVWsQ": "How To Protect Animals From The Heatwave? | NDMA"
    },
        "flood": {
        "0b0yrwHvCdc": "What to do and what not to do during floods | NDMA",
        "jWfzk90K8uI": "How to keep animals safe during floods? | NDMA",
        "pi_nUPcQz_A": "How To Survive Floods? | Preparing For A Flood | The Dr Binocs Show | Peekaboo Kidz",
        "xkf5R8KhnBk": "What should be done during floods.",
        "EJlYW3guRVQ": "During a Flood (ASL)"
    },
        "earthquakes": {
        "uxUPDevBkxk": "Earthquake - Tayyari Mein Hai Samajhdaari (English)",
        "g4ajSBb1_Ws": "NDMA INDIA Earthquake (Dost Appu - Hindi)",
        "ePMPqEmQLeA": "NDMA INDIA Earthquake Preparedness Films",
        "MRjq1AuD4Zw": "What to do when indoors during an earthquake?",
        "vTmJv94wZZ4": "Do's and don'ts during an earthquake",
        "mr1zhHpB0EI": "Is your home safe from earthquakes? (#SignLanguage) | NDMA"
    },
        "landslides": {
        "xnoheMCY0jc": "What to do and what not to do after a landslide.",
        "yOSBIlyTQVI": "NDMA INDIA Landslide (Dost Appu - Hindi)",
        "-2Y_MBVBJKU": "What to do and what not to do during a landslide.",
        "f-_iW_GamdU": "Sign Language - Learn from a geologist the methods of safety to avoid landslides.",
        "lQViP8bo04M": "Video on Landslide, Geologist, NDMA"
    },
        "tornado": {
        "_5TiTfuvotc": "Get Weather Ready: During a Tornado",
        "LT7yRMLAkCY": "What Causes a Tornado?",
        "TxfAiBV3aVg": "Tornado Safety Tips in American Sign Language (with Roger Robb)"
    },
        "thunderstorm": {
        "tItKhAebpuI": "How to Protect Yourself From Thunder and Lighting ? Safety Tips | Both Outdoors and Indoors.",
        "3MSHO8tOw5s": "HOW TO Stay Safe in a Lightning Storm | Hiking in a Thunderstorm | Lightning Safety Tips",
        "A9OX4uMwUOQ": "Weather Related Events - Tornado and Thunderstorms"
    },
        "drought": {
        "syAYdcdp_yg": "Drought Disaster Risk Reduction - Sign Language Video - KSDMA",
        "7CvUR_PissM": "Survival Tip: Be Prepared for Drought",
        "3vNnVrQSP_s": "Drought Video In Hindi | Dr.Binocs Show | Causes Of Drought"
    }
    }""".trimIndent()
val gson = Gson()
val type = object : TypeToken<Map<String, Map<String, String>>>() {}.type
val safetyTipsList: Map<String, Map<String, String>> = gson.fromJson(jsonString, type)



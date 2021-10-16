package com.android.andersenrecycleview

import java.util.*

object DataBase {
    private val contactsList = mutableListOf<Contact>()
    // да, знаю что это так себе, я почти весь день разбирался как получить json из url
    // не знаю даже че так тяжко пошло с ним, так же пробовал через retrofit
    // в общем уже вечер субботы, я регуляркой их очистил, а не руками и добавил прям здесь
    // json и retrofit как раз сегодня были, разберусь в течении недели как красивее сделать
    private val imagesUrlsList = mutableListOf(
        "https://picsum.photos/id/117/1544/1024",
        "https://picsum.photos/id/118/1500/1000",
        "https://picsum.photos/id/119/3264/2176",
        "https://picsum.photos/id/12/2500/1667",
        "https://picsum.photos/id/120/4928/3264",
        "https://picsum.photos/id/121/1600/1067",
        "https://picsum.photos/id/122/4147/2756",
        "https://picsum.photos/id/123/4928/3264",
        "https://picsum.photos/id/124/3504/2336",
        "https://picsum.photos/id/125/1500/1000",
        "https://picsum.photos/id/126/4272/2511",
        "https://picsum.photos/id/127/4032/2272",
        "https://picsum.photos/id/128/3823/2549",
        "https://picsum.photos/id/129/4910/3252",
        "https://picsum.photos/id/13/2500/1667",
        "https://picsum.photos/id/130/3807/2538",
        "https://picsum.photos/id/131/4698/3166",
        "https://picsum.photos/id/132/1600/1066",
        "https://picsum.photos/id/133/2742/1828",
        "https://picsum.photos/id/134/4928/3264",
        "https://picsum.photos/id/135/2560/1920",
        "https://picsum.photos/id/136/4032/2272",
        "https://picsum.photos/id/137/4752/3168",
        "https://picsum.photos/id/139/3465/3008",
        "https://picsum.photos/id/14/2500/1667",
        "https://picsum.photos/id/140/2448/2448",
        "https://picsum.photos/id/141/2048/1365",
        "https://picsum.photos/id/142/4272/2848",
        "https://picsum.photos/id/143/3600/2385",
        "https://picsum.photos/id/144/4912/2760",
        "https://picsum.photos/id/145/4288/2848",
        "https://picsum.photos/id/146/5184/3456",
        "https://picsum.photos/id/147/2448/2448",
        "https://picsum.photos/id/149/3454/2288",
        "https://picsum.photos/id/15/2500/1667",
        "https://picsum.photos/id/151/4288/3216",
        "https://picsum.photos/id/152/3888/2592",
        "https://picsum.photos/id/153/4763/3155",
        "https://picsum.photos/id/154/3264/2176",
        "https://picsum.photos/id/155/3264/2176",
        "https://picsum.photos/id/156/2177/3264",
        "https://picsum.photos/id/157/6211/4862",
        "https://picsum.photos/id/158/4836/3224",
        "https://picsum.photos/id/159/5184/2551",
        "https://picsum.photos/id/16/2500/1667",
        "https://picsum.photos/id/160/3200/2119",
        "https://picsum.photos/id/161/4240/2832",
        "https://picsum.photos/id/162/1500/998",
        "https://picsum.photos/id/163/2000/1333",
        "https://picsum.photos/id/164/1200/800",
        "https://picsum.photos/id/165/2000/1333",
        "https://picsum.photos/id/166/1280/720",
        "https://picsum.photos/id/167/2896/1944",
        "https://picsum.photos/id/168/1920/1280",
        "https://picsum.photos/id/169/2500/1662",
        "https://picsum.photos/id/17/2500/1667",
        "https://picsum.photos/id/170/2500/1667",
        "https://picsum.photos/id/171/2048/1536",
        "https://picsum.photos/id/172/2000/1325",
        "https://picsum.photos/id/173/1200/737",
        "https://picsum.photos/id/174/1600/589",
        "https://picsum.photos/id/175/2896/1944",
        "https://picsum.photos/id/176/2500/1662",
        "https://picsum.photos/id/177/2515/1830",
        "https://picsum.photos/id/178/2592/1936",
        "https://picsum.photos/id/179/2048/1365",
        "https://picsum.photos/id/18/2500/1667",
        "https://picsum.photos/id/180/2400/1600",
        "https://picsum.photos/id/181/1920/1189",
        "https://picsum.photos/id/182/2896/1944",
        "https://picsum.photos/id/183/2316/1544",
        "https://picsum.photos/id/184/4288/2848",
        "https://picsum.photos/id/185/3995/2662",
        "https://picsum.photos/id/186/2048/1275",
        "https://picsum.photos/id/187/4000/2667",
        "https://picsum.photos/id/188/2896/1936",
        "https://picsum.photos/id/189/2048/1536",
        "https://picsum.photos/id/19/2500/1667",
        "https://picsum.photos/id/190/2048/1365",
        "https://picsum.photos/id/191/2560/1707",
        "https://picsum.photos/id/192/2352/2352",
        "https://picsum.photos/id/193/3578/2451",
        "https://picsum.photos/id/194/2000/1325",
        "https://picsum.photos/id/195/768/1024",
        "https://picsum.photos/id/196/2048/1536",
        "https://picsum.photos/id/197/4272/2848",
        "https://picsum.photos/id/198/3456/2304",
        "https://picsum.photos/id/199/2592/1728",
        "https://picsum.photos/id/2/5616/3744",
        "https://picsum.photos/id/2/5616/3744",
        "https://picsum.photos/id/20/3670/2462",
        "https://picsum.photos/id/200/1920/1280",
        "https://picsum.photos/id/201/5184/3456",
        "https://picsum.photos/id/202/2392/1260",
        "https://picsum.photos/id/203/4032/3024",
        "https://picsum.photos/id/204/5184/3456",
        "https://picsum.photos/id/206/2880/1800",
        "https://picsum.photos/id/208/2002/1280",
        "https://picsum.photos/id/209/1920/1280",
        "https://picsum.photos/id/21/3008/2008",
        "https://picsum.photos/id/210/1920/1280"
    )

    init {
        contactsList.add(
            Contact(
                "Alex",
                "Navalny",
                "8-800-555-35-35",
                "https://picsum.photos/id/203/4032/3024"
            )
        )
        contactsList.add(Contact("Vova", "Putin", "+777", "https://picsum.photos/id/204/5184/3456"))
        contactsList.add(
            Contact(
                "Barak",
                "Obama",
                "+666",
                "https://picsum.photos/id/206/2880/1800"
            )
        )
        for (i in 0..100) {
            contactsList.add(
                Contact(
                    "person$i",
                    "family$i",
                    "+ ${((i + 1) * 10000000 * Math.random()).toInt()}",
                    imagesUrlsList[i]
                )
            )
        }
    }

    fun addContact(contact: Contact) {
        contactsList.add(contact)
    }

    fun removeByUid(uid: UUID): Boolean {
        return contactsList.remove(contactsList.firstOrNull { contact ->
            contact.contactUID == uid
        })
    }

    fun replaceContactByUuid(uuid: UUID, newContact: Contact) {
        if (removeByUid(uuid)) {
            addContact(newContact)
        }
    }

    fun findByUid(uid: UUID): Contact? {
        return contactsList.firstOrNull { contact ->
            contact.contactUID == uid
        }
    }

    fun getContacts(): List<Contact> {
        return contactsList
    }
}
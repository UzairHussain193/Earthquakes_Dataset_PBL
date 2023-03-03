class CollectionNode{
    CollectionNode next;
    Object country;
    Object city;
    Object magnitude;
    Object date;
    Object time;

    public CollectionNode(Object country,Object city, Object date, Object magnitude, Object time){
        this.country=country;
        this.city=city;
        this.magnitude=magnitude;
        this.time=time;
        this.date=date;
    }
    public CollectionNode(Object magnitude, Object date, Object time){
        this.magnitude=magnitude;
        this.time=time;
        this.date=date;
    }
    public CollectionNode(Object country,Object city, Object date, Object magnitude, Object time,CollectionNode next){
        this.country=country;
        this.city=city;
        this.magnitude=magnitude;
        this.time=time;
        this.date=date;
        this.next=next;
    }
}

class Collections {
    int year;
    CollectionNode head;
    

    
}

class MyHashSet {
ListNode ptr ; 
    public MyHashSet() {
        ptr = null ; 
    }
    
    public void add(int key) {
        if(ptr==null) {
            ptr = new ListNode(key);
            return ; 
        }
        if(contains(key)) return ; 
        ListNode head = new ListNode(key);
        head.next = ptr ; 
        ptr = head ; 

    }
    
    public void remove(int key) {
        if(ptr==null) return ; 
        if(ptr.val == key){
            ptr = ptr.next ; 
            return ; 
        }
        ListNode ptr1 = ptr , ptr2 = ptr.next ; 
        while(ptr2!=null&&ptr2.val!=key){
            ptr2=ptr2.next ; 
            ptr1=ptr1.next ; 
        }
        if(ptr2==null) return ; 
        ptr1.next = ptr2.next ; 
        
    }
    
    public boolean contains(int key) {
        ListNode ptr1 = ptr ; 
        while(ptr1!=null){
            if(ptr1.val==key)return true ; 
            ptr1 = ptr1.next ; 
        }
        return false ; 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//public class Counter {
//    public int getCount(){
//        return this.greetMap.size();
//    }
//
//    public int getCount(String userName){
//        return greetMap.get(userName);
//    }
//
//    public void clear(){
//        clear(null);
//    }
//
//    public void clear(String name){
//        clearUsers(name);
//    }
//
//    public boolean userExists(String userName){
//        return greetMap.containsKey(userName);
//    }
//
//    private void clearUsers(String name){
//        if(greetMap.containsKey(name)){
//            greetMap.remove(name);
//            return;
//        }
//        greetMap.clear();
//    }
//
//    private void updateCount(String name){
//        if(greetMap.containsKey(name)){
//            greetMap.put(name,greetMap.get(name)+1);
//        }else{
//            greetMap.put(name,1);
//        }
//}

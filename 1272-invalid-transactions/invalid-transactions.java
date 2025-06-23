class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int len = transactions.length;
        List<String> ret = new LinkedList<>();
        Map<String, List<Transaction>> map = new HashMap<>();

        for(String transaction : transactions){
            Transaction tran = new Transaction(transaction);
            if(!map.containsKey(tran.name)){
                map.put(tran.name, new LinkedList<>());
            }
            map.get(tran.name).add(tran);
        }

        for(String transaction : transactions){
            Transaction tran = new Transaction(transaction);

            if(!isValid(map.get(tran.name), tran)) ret.add(transaction);
        }

        return ret;
    }

    public boolean isValid(List<Transaction> list, Transaction tran){
        if(tran.amount > 1000) return false;
        for(Transaction ts : list){
            if(tran.diffCityTransactions(ts)) return false;
        }
        return true;
    }

    class Transaction {
        String name;
        int time;
        int amount;
        String city;

        Transaction(String str){
            String[] array = str.split(",");
            name = array[0];
            time = Integer.parseInt(array[1]);
            amount = Integer.parseInt(array[2]);
            city = array[3];
        }

        public boolean invalidAmount(){
            return this.amount > 1000;
        }

        public boolean diffCityTransactions(Transaction ts){
            return !this.city.equals(ts.city) && Math.abs(this.time - ts.time) <= 60;
        }
    }
}
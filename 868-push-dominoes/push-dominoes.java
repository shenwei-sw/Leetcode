class Solution {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        int[] forces = new int[len];
        int force = 0;
        for(int i = 0; i < len; i++){
            char ch = dominoes.charAt(i);
            if(ch == 'R') force = len;
            else if(ch == 'L') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] = force;
        }
        force = 0;
        for(int i = len - 1; i >= 0; i--){
            char ch = dominoes.charAt(i);
            if(ch == 'L') force = len;
            else if(ch == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] -= force;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            char ch = forces[i] > 0? 'R' : forces[i] < 0? 'L' : '.';
            sb.append(ch);
        }
        return sb.toString();
    }
}
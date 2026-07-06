class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int endTime = attacks[attacks.length - 1][0];
        int healTime = 0; // 지속시간
        int hp = health; // 현재 체력
        int requiredTime = bandage[0];
        int healPerSec = bandage[1];
        int bonusHeal = bandage[2];
        
        int index = 0;
        int attackTime = attacks[index][0];
        int attackDamage = attacks[index++][1];
        for (int i = 0; i <= endTime; i++) {
            if (i == attackTime) {
                hp -= attackDamage;
                if (hp <= 0) return -1;
                healTime = 0;
                
                if (attackTime == endTime) break;
                attackTime = attacks[index][0];
                attackDamage = attacks[index++][1];
            } else {
                if (hp == health) continue;
                healTime++;
                hp = Math.min(hp + healPerSec, health);
                if (healTime == requiredTime) {
                    healTime = 0;
                    hp = Math.min(hp + bonusHeal, health);
                }
            }
        }
        return hp;
    }
}
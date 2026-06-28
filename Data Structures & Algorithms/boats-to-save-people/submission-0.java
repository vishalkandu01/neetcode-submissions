class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int n = people.length;
        int s = 0, e = n - 1;
        int boatCount = 0;

        while (s <= e) {
            if (people[s] + people[e] <= limit) {
                s++;
                e--;
                boatCount++;
            } else if (people[s] + people[e] > limit) {
                e--;
                boatCount++;
            }
        }

        return boatCount;
    }
}
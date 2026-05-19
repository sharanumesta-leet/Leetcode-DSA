function getCommon(nums1: number[], nums2: number[]): number {
    let n1: number = nums1.length;
    let n2: number = nums2.length;
    let i: number = 0;
    let j: number = 0;
    while (i < n1 && j < n2) {
        if (nums1[i] < nums2[j])
            i++;
        else if (nums1[i] > nums2[j])
            j++;
        else
            return nums1[i];
    }
    return -1;
};
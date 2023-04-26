/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* mergeTwo(struct ListNode* head1, struct ListNode* head2) {
    struct ListNode* sentinel = (struct ListNode*)malloc(sizeof(struct ListNode));
    sentinel->next = NULL;
    struct ListNode* cur = sentinel;
    while (head1 != NULL && head2 != NULL) {
        if (head1->val < head2->val) {
            cur->next = head1;
            head1 = head1->next;
        } else {
            cur->next = head2;
            head2 = head2->next;
        }
        cur = cur->next;
    }
    cur->next = head1 == NULL ? head2 : head1;
    return sentinel->next;
}

struct ListNode* mergeLists(struct ListNode** lists, int start, int end) {
    //only one ListNode in the list
    if (start + 1 == end) {
        return lists[start];
    }

    int mid = (start + end) / 2;
    //merge index start ~ mid - 1
    struct ListNode* head1 = mergeLists(lists, start, mid);
    //merge index start ~ mid - 1
    struct ListNode* head2 = mergeLists(lists, mid, end);
    return mergeTwo(head1, head2);
}

struct ListNode* mergeKLists(struct ListNode** lists, int listsSize){
    if (listsSize == 0) {
        return NULL;
    }
    return mergeLists(lists, 0, listsSize);
}
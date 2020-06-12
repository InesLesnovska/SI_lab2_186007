
**����� ������������� ����� �� ���������� �����������
���� ���������, ��. �� ������ 186007**

**

## ����� �� ���:


�� ����� ������� �� ��� 2

## Control Flow Graph

![graf](https://ibb.co/nDHfZkB)

## ����������� ������������

������������� ������������ �� ��� ��� � 8, ������� ��� � ������� �� ����� �� ������� �� ������.

## ���� ������ ������ ����������� Every statement

1. user=null -> A, B, P
2. username=(already exists), email=smth -> A, C, D, P 
3. username=(valid username), email=null -> A, C, E, F, P
4. username=(valid username), email=abc -> A, C, E, G, H.1, H.2, I, K, H.3, M, N, P
5. username=(valid username), email=ines@gmail.com -> A, C, E, G, H.1, H.2, I, J, K, L, H.3, M, O, P

## ���� ������ ������ ����������� Every path

A, B, P
A, C, D, P
A, C, E, F, P
A, C, E, G, H.1, H.2, M, O, P (mailot e prazen string, ne e vozmozhno)
A, C, E, G, H.1, H.2, M, N, P
A, C, E, G, H.1, (H.2, I, K, H.3), M, N, P
A, C, E, G, H.1, (H.2, I, K, H.3), M, O, P (ne e validen emailot, ne e vozmozhno)
A, C, E, G, H.1, (H.2, I, J, K, H.3), M, N, P 
A, C, E, G, H.1, (H.2, I, J, K, H.3), M, O, P (ne e validen emailot, ne e vozmozhno)
A, C, E, G, H.1, (H.2, I, K, L, H.3), M, N, P (ne mozhe da otide do K, ako barem ednash ne otide do J)
A, C, E, G, H.1, (H.2, I, K, L, H.3), M, O, P (ne e validen emailot, ne e vozmozhno)
A, C, E, G, H.1, (H.2, I, J, K, L, H.3), M, N, P (emailot e validen, ne e vozmozhno)
A, C, E, G, H.1, (H.2, I, J, K, L, H.3), M, O, P


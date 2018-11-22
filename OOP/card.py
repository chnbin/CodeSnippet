import random
print('♦♠♥♣')

class Card:
    def __init__(self, rank, suit, hard, soft):
        self.rank = rank
        self.suit = suit
        self.hard = hard
        self.soft = soft

    def __str__(self):
        return 'rank: '+self.rank+', suit: '+str(self.suit)+', hard: '+str(self.hard)+', soft: '+str(self.soft)+'.'

class NumberCard(Card):
    def __init__(self, rank, suit):
        super().__init__(str(rank), suit, rank, rank)
    

class AceCard(Card):
    def __init__(self, rank, suit):
        super().__init__('A', suit, 1, 11)

class FaceCard(Card):
    def __init__(self, rank, suit):
        dict = {11: 'J', 12: 'Q', 13: 'K'}
        super().__init__(dict[rank], suit, 10, 10)

class Suit:
    def __init__(self, name, symbol):
        self.name = name
        self.symbol = symbol

    def __str__(self):
        return 'name: ' + self.name + ',symbol: ' + self.symbol
# cards = [AceCard('A', '♠'), NumberCard('2', '♦')]

Club = Suit('Club', '♣')
Diamond = Suit('Diamond', '♦')
Heart = Suit('Heart', '♥')
Spade = Suit('Spade', '♠')

cards = [AceCard('A', Spade), NumberCard('2', Diamond)]

def card(rank, suit):
    dict = {11: 'J', 12: 'Q', 13: 'K'}
    if rank == 1:
        return AceCard('A', suit)
    elif 2 <= rank <= 10:
        return NumberCard(str(rank), suit)
    elif 11 <= rank <= 13:
        return FaceCard(dict[rank], suit)
    else:
        raise Exception('Rank out of range.')

def card10(rank, suit):
    if rank == 1:
        return AceCard('A', suit)
    elif 2 <= rank <= 10:
        return NumberCard(rank, suit)
    elif 11 <= rank <= 13:
        return FaceCard(rank, suit)
    else:
        raise Exception('Rank out of range.')

deck = [card10(rank, suit) for rank in range(1, 14) for suit in [Club, Diamond, Heart, Spade]]

for card in deck:
    print(card)

class Deck:
    def __init__(self):
        self.card = [card10(rank, suit) for rank in range(1, 14) for suit in [Club, Diamond, Heart, Spade]]
        random.shuffle(self.card)
    def pop(self):
        return self.card.pop()
d = Deck()
print(d.pop())
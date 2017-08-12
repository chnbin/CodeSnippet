# create a mapping of state to abbreviation

states ={
    'Oregon': 'OR',
    'Florida': 'FL',
    'California': 'CA',
    'New York': 'NY',
    'Michigan': 'MI',
    'Texas': 'TX'
}

# create a basic set of states and some cities in them

cities = {
    'CA': 'San Francisco',
    'MI': 'Detroit',
    'FL': 'Jacksonville'
}

# add some more cities

cities['NY'] = 'New York'
cities['OR'] = 'Portland'

# print some cities
print ("-" * 10)
print ("Michigan's abbreviation is:" ,states['Michigan'])
print ("Florida's abbreviation is:" ,states['Florida'])

print ("-" * 10)
for state, abbrev in states.items():
    print ("%s is abbreviated %s" % (state, abbrev))

print ("-" * 10)
for abbrev, city in cities.items():
    print ("%s has the city %s" % (abbrev, city))

print ("-" * 10)
state = states.get('Texas')
print (state)
if not state:
    print("Sorry, no Texas")

# get a city with a default value
city = cities.get('TX','Does not exist')
print ("The city for the state 'TX' is: %s" % city)

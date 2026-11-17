

def function(x):
    return (x + 3) ** 2

def derivative(x):
    return 2 * (x + 3)

x = 2

learning_rate = 0.1

iterations = 50

for i in range(iterations):
    gradient = derivative(x)
    x = x - learning_rate * gradient

print("Local minimum point (x):", round(x, 6))
print("Minimum value (y):", round(function(x), 6))

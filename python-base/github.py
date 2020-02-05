from dulwich.repo import Repo

r = Repo('.')
print(r.head().decode('UTF-8'))

c = r[r.head()]
print(c.message.decode('UTF-8'))
import os

'''
check whether the commit messages contain weakness type or CVE ID. 
'''

weakness_keywords = ["injection", "memory", "buffer", "out-of-bound", "out of bound", "overflow", "improper", "security"]
security_keywords = ["bug", "error", "flaw", "mistake"]


def keyword_test(file_name, test_result_name):
    count = 1
    weakness_flag = False
    cve_flag = False
    security_flag = False

    test_file = open(test_result_name, "a+")

    path = os.getcwd() + '/' + file_name
    f = open(path, "r")
    lines = f.readlines()
    line_iter = iter(lines)

    for line in line_iter:
        try:
            line_int = int(line)
            if line_int == count:
                if weakness_flag or cve_flag or security_flag:
                    test_file.write(str(count - 1) + "\n")
                    if weakness_flag:
                        test_file.write("weakness\n")
                    if cve_flag:
                        test_file.write("cve\n")
                    if security_flag:
                        test_file.write("security\n")
                    test_file.write("\n")
                cve_flag = False
                weakness_flag = False
                security_flag = False
                count += 1
                next(line_iter, None)
        except ValueError:
            ## check for any mention of 'CVE-XXXX-XXXX'
            if "CVE-" in line and not cve_flag:
                cve_flag = True

            ## check for any mention of famous weakness names
            if not weakness_flag:
                for keyword in weakness_keywords:
                    if keyword in line:
                        weakness_flag = True
                        break

            ## check for any mention of security weakness
            if not security_flag:
                for keyword in security_keywords:
                    if keyword in line:
                        security_flag = True
                        break

    test_file.close()
    f.close()


'''
scraps commit messages from the diff files
'''

def scrape_message(message_file_name, diff_folder):
    ## extract OpenSource folder names
    path = os.getcwd() + diff_folder
    dir_list = [e for e in os.listdir(path) if (os.path.isdir(path + e) and e[0] != '.')]
    print(dir_list)

    count = 0  # number of commit message extracted
    message_file = open(message_file_name, "a+")

    for dir_name in dir_list:
        full_dir_path = path + dir_name
        ## for each diff file in each folder
        for file in os.listdir(full_dir_path):
            file_name = os.path.join(full_dir_path, file)
            if os.path.isfile(file_name):
                # print(fileName)
                ## open the diff file
                try:
                    f = open(file_name, "r")
                    f1 = f.readlines()

                    ## extract messages only and write them into a txt file
                    message_flag = False
                    for line in f1:
                        if message_flag and line[0:4] == "diff":
                            break
                        elif message_flag:
                            message_file.write(line)
                        elif line == '\n':
                            message_flag = True
                            count += 1
                            message_file.write(str(count) + '\n' + file_name + '\n')
                    f.close()
                except UnicodeDecodeError as e:
                    error_file = open("UnicodeDecodeError.txt", "a+")
                    error_file.write(file_name + '\n')
                    error_file.write(line)
                    error_file.write(str(e) + '\n\n')
                    error_file.close()
    message_file.write(str(count+1))
    message_file.close()
    print(count)


def main():
    # message_file_name = "messages.txt"
    # diff_folder = '/vul_patch/'
    # test_result_name = "keywordTest.txt"
    #
    # scrape_message(message_file_name, diff_folder)
    # keyword_test(message_file_name, test_result_name)


    least_msg_file_name = "least_messages.txt"
    least_diff_folder = '/least_cve/'
    least_test_name = "least_keywordTest.txt"

    scrape_message(least_msg_file_name, least_diff_folder)
    keyword_test(least_msg_file_name, least_test_name)


main()
